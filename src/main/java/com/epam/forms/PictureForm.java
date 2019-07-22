package com.epam.forms;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PictureForm {
    private Integer albumId;
    private List<MultipartFile> files;

    public PictureForm(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
