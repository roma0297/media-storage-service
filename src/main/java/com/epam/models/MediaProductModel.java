package com.epam.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class MediaProductModel {
    private Integer id;
    private String name;
    private String description;
    private Integer rank;
    private LocalDateTime createDateTime;

    public MediaProductModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDateTime = createDateTime;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Column(name = "createDateTime")
    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
