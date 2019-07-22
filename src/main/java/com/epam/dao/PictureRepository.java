package com.epam.dao;

import com.epam.models.PictureModel;
import com.epam.services.MediaStorageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import com.epam.models.PictureAlbumModel;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PictureRepository {
    private static final String albumType = "images";
    private static final String IMAGE_ALBUMS_FOLDER = MediaStorageService.PATH_TO_FILES + "/" + albumType;
    private static List<PictureAlbumModel> pictureAlbums = new LinkedList<>();

    static {
        try {
            if (!Files.exists(Paths.get(MediaStorageService.PATH_TO_FILES))){
                Files.createDirectory(Paths.get(MediaStorageService.PATH_TO_FILES));
            }
            if (!Files.exists(Paths.get(IMAGE_ALBUMS_FOLDER))) {
                Files.createDirectory(Paths.get(IMAGE_ALBUMS_FOLDER));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        AtomicInteger atomicInteger = new AtomicInteger(0);

        File albumsFolder = new File(IMAGE_ALBUMS_FOLDER);
        FileUtils.listFilesAndDirs(albumsFolder, FalseFileFilter.FALSE, DirectoryFileFilter.DIRECTORY)
                .forEach(directory -> {
                    if (!directory.equals(albumsFolder)) {
                        atomicInteger.getAndIncrement();
                        pictureAlbums.add(new PictureAlbumModel(atomicInteger.get(), directory.getName(),
                                "Test description" + Integer.toString(atomicInteger.get()),
                                atomicInteger.get(), LocalDateTime.now()));
                    }
                });
    }

    public PictureAlbumModel getPictureAlbumBy(Integer albumId) {
        return pictureAlbums.stream()
                .filter(pictureAlbum -> albumId.equals(pictureAlbum.getId()))
                .findFirst()
                .orElseThrow();
    }

    public List<PictureAlbumModel> getPictureAlbums() {
        return pictureAlbums;
    }

    public List<PictureModel> getPicturesBy(Integer albumId) {
        String albumName = pictureAlbums.stream()
                .filter(pictureAlbum -> albumId.equals(pictureAlbum.getId()))
                .findFirst()
                .orElseThrow()
                .getName();

        List<PictureModel> pictures = new LinkedList<>();
        File albumFolder = new File(IMAGE_ALBUMS_FOLDER + "/" + albumName);
        FileUtils.listFiles(albumFolder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
                .forEach(file -> {
                    // original file name
                    String name = StringUtils.substringBeforeLast(file.getName(), ".");
                    // path to /images folder
                    String imagePath = StringUtils.substringAfter(file.getAbsolutePath(),
                            albumType);

                    pictures.add(new PictureModel(1, albumId, name, "/media/" + albumType + imagePath));
                });

        return pictures;
    }

    public void addNewAlbumInfo(String albumName, String albumDescription) {
        pictureAlbums.add(new PictureAlbumModel(pictureAlbums.size() + 1, albumName, albumDescription,
                pictureAlbums.size() + 1, LocalDateTime.now()));
    }
}
