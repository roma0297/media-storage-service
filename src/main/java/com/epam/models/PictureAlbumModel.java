package com.epam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "PictureAlbumModel")
public class PictureAlbumModel extends MediaProductModel {
    private Integer rank;

    public PictureAlbumModel(Integer id, String name, String description, Integer rank, LocalDateTime createDateTime) {
        super(id, name, description, createDateTime);
        this.rank = rank;
    }

    @Column(name = "rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
