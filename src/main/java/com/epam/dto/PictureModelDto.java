package com.epam.dto;

public class PictureModelDto {
    private String originalName;
    private String fileSystemPath;

    public PictureModelDto(String originalName, String fileSystemPath) {
        this.originalName = originalName;
        this.fileSystemPath = fileSystemPath;
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
