package com.epam.dao;

import com.epam.models.MusicAlbumModel;
import com.epam.models.MusicModel;
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
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MusicRepository {
    private static final String albumType = "music";
    private static final String MUSIC_ALBUMS_FOLDER = MediaStorageService.PATH_TO_FILES + "/" + albumType;
    private static List<MusicAlbumModel> musicAlbums = new LinkedList<>();

    static {
        try {
            if (!Files.exists(Paths.get(MediaStorageService.PATH_TO_FILES))){
                Files.createDirectory(Paths.get(MediaStorageService.PATH_TO_FILES));
            }
            if (!Files.exists(Paths.get(MUSIC_ALBUMS_FOLDER))) {
                Files.createDirectory(Paths.get(MUSIC_ALBUMS_FOLDER));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        AtomicInteger atomicInteger = new AtomicInteger(0);

        File albumsFolder = new File(MUSIC_ALBUMS_FOLDER);
        FileUtils.listFilesAndDirs(albumsFolder, FalseFileFilter.FALSE, DirectoryFileFilter.DIRECTORY)
                .forEach(directory -> {
                    if (!directory.equals(albumsFolder)) {
                        atomicInteger.getAndIncrement();
                        musicAlbums.add(new MusicAlbumModel(atomicInteger.get(), directory.getName(),
                                "Test description" + Integer.toString(atomicInteger.get()),
                                atomicInteger.get(), LocalDateTime.now(),""));
                    }
                });
    }

    public MusicAlbumModel getMusicAlbumBy(Integer albumId) {
        return musicAlbums.stream()
                .filter(musicAlbum -> albumId.equals(musicAlbum.getId()))
                .findFirst()
                .orElseThrow();
    }

    public List<MusicAlbumModel> getMusicAlbums() {
        return musicAlbums;
    }

    public List<MusicModel> getMusicBy(Integer albumId) {
        String albumName = musicAlbums.stream()
                .filter(musicAlbum -> albumId.equals(musicAlbum.getId()))
                .findFirst()
                .orElseThrow()
                .getName();

        List<MusicModel> music = new LinkedList<>();
        File albumFolder = new File(MUSIC_ALBUMS_FOLDER + "/" + albumName);
        FileUtils.listFiles(albumFolder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
                .forEach(file -> {
                    // original file name
                    String name = StringUtils.substringBeforeLast(file.getName(), ".");
                    // path to /images folder
                    String imagePath = StringUtils.substringAfter(file.getAbsolutePath(),
                            albumType);

                    music.add(MusicModel.builder()
                            .id(1)
                            .albumId(albumId)
                            .originalName(name)
                            .fileSystemPath("/media/" + albumType + imagePath)
                            .build()
                    );
                });

        return music;
    }

    public void addNewAlbumInfo(String albumName, String albumDescription) {
        musicAlbums.add(new MusicAlbumModel(musicAlbums.size() + 1, albumName, albumDescription,
                musicAlbums.size() + 1, LocalDateTime.now(), "artist"));
    }
}
