package com.epam.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "picture_albums")
@Getter
@Setter
public class PictureAlbumModel extends MediaProductModel {
    @Builder
    public PictureAlbumModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime) {
        super(id, name, description, rank, createDateTime);
    }
}
