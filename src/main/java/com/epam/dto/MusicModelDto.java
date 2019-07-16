package com.epam.dto;

public class MusicModelDto {
    private String originalName;
    private String fileSystemPath;

    public String getOriginalName(){
        return originalName;
    }

    public void setOriginalName(String originalName){
        this.originalName = originalName;
    }

    public String getFileSystemPath(){
        return fileSystemPath;
    }

    public void setFileSystemPath(){
        this.fileSystemPath = fileSystemPath;
    }
}
