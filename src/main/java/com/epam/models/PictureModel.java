package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "pictures")
@Builder
@Getter
@Setter
public class PictureModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "albumId")
    private Integer albumId;

    @Column(name = "originalName")
    private String originalName;

    @Column(name = "fileSystemPath")
    private String fileSystemPath;
}
