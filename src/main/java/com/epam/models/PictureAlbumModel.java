package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "picture_albums")
@Builder
@Getter
@Setter
public class PictureAlbumModel extends MediaProductModel {
    @Column(name = "rank")
    private Integer rank;
}
