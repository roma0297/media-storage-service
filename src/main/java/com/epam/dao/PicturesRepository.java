package com.epam.dao;

import org.springframework.stereotype.Repository;
import java.util.List;
import com.epam.models.PictureAlbumModel;
import java.time.LocalDateTime;
import java.util.Arrays;

@Repository
public class PicturesRepository {

    private static final List<PictureAlbumModel> PICTURE_ALBUMS;

    static {
        PICTURE_ALBUMS = Arrays.asList(
                new PictureAlbumModel(1, "Vegetables", "Something from nature", 0, LocalDateTime.now()),
                new PictureAlbumModel(2, "Waterfalls", "Something from journals", 0, LocalDateTime.now()),
                new PictureAlbumModel(3, "Industry", "Something from programming life",
                        0, LocalDateTime.now()),
                new PictureAlbumModel(4, "Mountains", "Something from adventures", 0, LocalDateTime.now())
        );
    }

    public List<PictureAlbumModel> getPictureAlbums() {
        return PICTURE_ALBUMS;
    }
}
