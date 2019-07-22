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
    @Column(name = "rank")
    private Integer rank;

    @Builder
    public PictureAlbumModel(Integer id, String name, String description, LocalDateTime createDateTime, Integer rank) {
        super(id, name, description, createDateTime);
        this.rank = rank;
    }
}
