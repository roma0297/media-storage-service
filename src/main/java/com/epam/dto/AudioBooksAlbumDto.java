package com.epam.dto;

public class AudioBooksAlbumDto {
    private String name;
    private String description;

    public AudioBooksAlbumDto(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
