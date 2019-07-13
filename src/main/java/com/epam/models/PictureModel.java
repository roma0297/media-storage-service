package com.epam.models;

public class PictureModel {
    private Integer id;
    private Integer albumId;
    private String originalName;
    private String fileSystemPath;

    public PictureModel(Integer id, Integer albumId, String originalName, String fileSystemPath) {
        this.id = id;
        this.albumId = albumId;
        this.originalName = originalName;
        this.fileSystemPath = fileSystemPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getFileSystemPath() {
        return fileSystemPath;
    }

    public void setFileSystemPath(String fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }
}
