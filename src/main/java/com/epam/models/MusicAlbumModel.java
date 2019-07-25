package com.epam.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "music_albums")
@Getter
@Setter
public class MusicAlbumModel extends MediaProductModel {
    @Column(name = "artist")
    private String artist;

    @Builder
    public MusicAlbumModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime, String artist) {
        super(id, name, description, rank, createDateTime);
        this.artist = artist;
    }
}
