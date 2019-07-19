package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "music_albums")
@Builder
@Getter
@Setter
public class MusicAlbumModel extends MediaProductModel {

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "artist")
    private String artist;
}
