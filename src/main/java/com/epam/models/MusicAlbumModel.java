package com.epam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "MusicAlbumModel")
public class MusicAlbumModel extends MediaProductModel {
    private Integer rank;
    private String artist;

    public MusicAlbumModel(Integer id, String name, String artist, String description, Integer rank, LocalDateTime createDateTime) {
        super(id, name, description, createDateTime);
        this.rank = rank;
        this.artist = artist;
    }

    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Column(name = "artist")
    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

}
