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
public class AudioBooksModel extends MediaProductModel {

    @Column(name = "writer")
    private String writer;

    @Builder
    public AudioBooksModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime, String writer) {
        super(id, name, description, rank, createDateTime);
        this.writer = writer;
    }
}