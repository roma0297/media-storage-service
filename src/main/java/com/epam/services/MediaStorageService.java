package com.epam.services;

import com.fasterxml.uuid.Generators;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MediaStorageService {
    private String albumType;
    public static final String PATH_TO_FILES = System.getProperty("user.home") + "/serverFiles";

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public void saveFiles(List<MultipartFile> files, String albumName) {
        files.forEach(file -> {
            try {
                String nameUuid = Generators.timeBasedGenerator().generate().toString();
                String tempFileName = nameUuid + "."
                        + StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
                file.transferTo(new File(PATH_TO_FILES + "/" + albumType
                        + "/" + albumName
                        + "/" + tempFileName));
            } catch (IOException e) {
                System.out.println("Current path [" + PATH_TO_FILES + "] already exists");
            }
        });
    }
}
