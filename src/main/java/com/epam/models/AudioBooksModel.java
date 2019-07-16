package com.epam.models;

public class AudioBooksModel {
    private Integer id;
    private Integer index;
    private String originalName;
    private String fileSystemPath;

    public AudioBooksModel(Integer id, Integer index, String originalName, String fileSystemPath) {
        this.id = id;
        this.index = index;
        this.originalName = originalName;
        this.fileSystemPath = fileSystemPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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
