package com.epam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "AudioBooksAlbum")
public class AudioBooksAlbumModel extends MediaProductModel {
    private String artist;
    private String writer;

    public AudioBooksAlbumModel(Integer id, String name, String artist, String writer, String description, Integer rank, LocalDateTime createDateTime) {
        super(id, name, description, rank, createDateTime);
        this.artist = artist;
        this.writer = writer;
    }

    @Column(name = "artist")
    public String getArtist(){
        return artist;
    }

    public void  setArtist(String artist){
        this.artist = artist;
    }

    @Column(name = "writer")
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
