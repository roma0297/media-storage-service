package com.epam.dao;

import com.epam.models.AudioBookModel;
import com.epam.models.AudioBooksModel;
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
public class AudioBooksRepository {

    private static final String albumType = "audio";
    private static final String AUDIOBOOKS_FOLDER = MediaStorageService.PATH_TO_FILES + "/" + albumType;
    private static List<AudioBooksModel> audioBooks = new LinkedList<>();

    static {
        try {
            if (!Files.exists(Paths.get(MediaStorageService.PATH_TO_FILES))) {
                Files.createDirectory(Paths.get(MediaStorageService.PATH_TO_FILES));
            }
            if (!Files.exists(Paths.get(AUDIOBOOKS_FOLDER))) {
                Files.createDirectory(Paths.get(AUDIOBOOKS_FOLDER));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        AtomicInteger atomicInteger = new AtomicInteger(0);

        File albumsFolder = new File(AUDIOBOOKS_FOLDER);
        FileUtils.listFilesAndDirs(albumsFolder, FalseFileFilter.FALSE, DirectoryFileFilter.DIRECTORY)
                .forEach(directory -> {
                    if (!directory.equals(albumsFolder)) {
                        atomicInteger.getAndIncrement();
                        audioBooks.add(new AudioBooksModel(atomicInteger.get(), directory.getName(),
                                "Test description" + Integer.toString(atomicInteger.get()),
                                atomicInteger.get(), LocalDateTime.now(), "writer"));
                    }
                });
    }

    public AudioBooksModel getAudioBooksBy(Integer albumId) {
        return audioBooks.stream()
                .filter(audioBook -> albumId.equals(audioBook.getId()))
                .findFirst()
                .orElseThrow();
    }

    public List<AudioBooksModel> getAudioBooks() {
        return audioBooks;
    }

    public List<AudioBookModel> getAudioBookBy(Integer albumId) {
        String albumName = audioBooks.stream()
                .filter(audioBook -> albumId.equals(audioBook.getId()))
                .findFirst()
                .orElseThrow()
                .getName();

        List<AudioBookModel> audiobook = new LinkedList<>();
        File albumFolder = new File(AUDIOBOOKS_FOLDER + "/" + albumName);
        FileUtils.listFiles(albumFolder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)
                .forEach(file -> {
                    // original file name
                    String name = StringUtils.substringBeforeLast(file.getName(), ".");
                    // path to /images folder
                    String imagePath = StringUtils.substringAfter(file.getAbsolutePath(),
                            albumType);

                    audiobook.add(AudioBookModel.builder()
                            .id(1)
                            .albumId(albumId)
                            .originalName(name)
                            .fileSystemPath("/media/" + albumType + imagePath)
                            .build()
                    );
                });

        return audiobook;
    }

    public void addNewAlbumInfo(String albumName, String albumDescription, String writer) {
        audioBooks.add(new AudioBooksModel(audioBooks.size() + 1, albumName, albumDescription,
                audioBooks.size() + 1, LocalDateTime.now(), writer));
    }
}
