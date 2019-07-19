package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "audio_book_tracks")
@Builder
@Getter
@Setter
public class AudioBooksModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "originalName")
    private String originalName;

    @Column(name = "fileSystemPath")
    private String fileSystemPath;
}
