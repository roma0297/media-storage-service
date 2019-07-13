package com.epam.models;

import java.time.LocalDateTime;

public abstract class MediaProductModel {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createDateTime;

    public MediaProductModel(Integer id, String name, String description, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDateTime = createDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
