package com.epam.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "audio_book_tracks")
@Getter
@Setter
public class AudioBookModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "albumId")
    private Integer albumId;

    @Column(name = "originalName")
    private String originalName;

    @Column(name = "fileSystemPath")
    private String fileSystemPath;
}

