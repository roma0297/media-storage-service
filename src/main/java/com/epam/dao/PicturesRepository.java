package com.epam.dao;

import com.epam.models.PictureAlbumModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class PicturesRepository {

    private static final List<PictureAlbumModel> PICTURE_ALBUMS;

    static {
        PICTURE_ALBUMS = Arrays.asList(PictureAlbumModel.builder()
                        .id(1)
                        .name("Vegetables")
                        .description("Something from nature")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                PictureAlbumModel.builder()
                        .id(2)
                        .name("Waterfalls")
                        .description("Something from journals")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                PictureAlbumModel.builder()
                        .id(3)
                        .name("Industry")
                        .description("Something from programming life")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build(),
                PictureAlbumModel.builder()
                        .id(4)
                        .name("Mountains")
                        .description("Something from adventures")
                        .rank(0)
                        .createDateTime(LocalDateTime.now())
                        .build());
    }

    public List<PictureAlbumModel> getPictureAlbums() {
        return PICTURE_ALBUMS;
    }
}
