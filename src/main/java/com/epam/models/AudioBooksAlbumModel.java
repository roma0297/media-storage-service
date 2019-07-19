package com.epam.models;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "audio_books")
@Builder
@Getter
@Setter
public class AudioBooksAlbumModel extends MediaProductModel {

    @Column(name = "rank")
    private Integer rank;

    @Column(name = "artist")
    private String artist;

    @Column(name = "writer")
    private String writer;
}
