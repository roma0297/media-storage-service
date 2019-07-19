package com.epam.models;

import javax.persistence.*;

@Entity
@Table(name = "AudioBooks")
public class AudioBooksModel {
    private Integer id;
    private Integer rank;
    private String originalName;
    private String fileSystemPath;

    public AudioBooksModel(Integer id, Integer rank, String originalName, String fileSystemPath) {
        this.id = id;
        this.rank = rank;
        this.originalName = originalName;
        this.fileSystemPath = fileSystemPath;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Column(name = "originalName")
    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Column(name = "fileSystemPath")
    public String getFileSystemPath() {
        return fileSystemPath;
    }

    public void setFileSystemPath(String fileSystemPath) {
        this.fileSystemPath = fileSystemPath;
    }
}
