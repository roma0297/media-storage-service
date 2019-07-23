package com.epam.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "audio_books")
@Getter
@Setter
public class AudioBookModel extends MediaProductModel {
    @Column(name = "artist")
    private String artist;

    @Column(name = "writer")
    private String writer;

    @Builder
    public AudioBookModel(Integer id, String name, String description, LocalDateTime createDateTime, Integer rank, String artist, String writer) {
        super(id, name, description, rank, createDateTime);
        this.artist = artist;
        this.writer = writer;
    }
}
