package com.epam.models;

import java.time.LocalDateTime;

public class PictureAlbumModel extends MediaProductModel {
    private Integer index;

    public PictureAlbumModel(Integer id, String name, String description, Integer index, LocalDateTime createDateTime) {
        super(id, name, description, createDateTime);
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
