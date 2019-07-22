package com.epam.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PictureAlbumModel")
public class PictureAlbumModel extends MediaProductModel {
    public PictureAlbumModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime) {
        super(id, name, description, rank, createDateTime);
    }
}
