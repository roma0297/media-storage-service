package com.epam.models;

import java.time.LocalDateTime;

public class MusicAlbumModel extends MediaProductModel {
    private Integer index;
    private String artist;

    public MusicAlbumModel(Integer id, String name, String artist, String description, Integer index, LocalDateTime createDateTime) {
        super(id, name, description, createDateTime);
        this.index = index;
        this.artist = artist;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer order) {
        this.index = index;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

}
