package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "music_tracks")
@Getter
@Setter
public class MusicModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "originalName")
    private String originalName;

    @Column(name = "fileSystemPath")
    private String fileSystemPath;
}
