package com.epam.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
