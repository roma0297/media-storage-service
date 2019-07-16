package com.epam.models;

import java.time.LocalDateTime;

public class AudioBooksAlbumModel extends MediaProductModel {
    private Integer index;
    private String artist;
    private String writer;

    public AudioBooksAlbumModel(Integer id, String name, String artist, String writer, String description, Integer index, LocalDateTime createDateTime) {
        super(id, name, description, createDateTime);
        this.index = index;
        this.artist = artist;
        this.writer = writer;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getArtist(){
        return artist;
    }

    public void  setArtist(String artist){
        this.artist = artist;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
