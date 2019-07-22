package com.epam.dao;

import com.epam.models.MusicAlbumModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class MusicRepository {

    private static final List<MusicAlbumModel> MUSIC_ALBUMS;

    static {
        MUSIC_ALBUMS = Arrays.asList(MusicAlbumModel.builder()
                        .id(1)
                        .name("No.6 Collaborations Project")
                        .description("Ed Sheeran")
                        .artist("Ed Sheeran")
                        .createDateTime(LocalDateTime.now())
                        .rank(0)
                        .build(),
                MusicAlbumModel.builder()
                        .id(2)
                        .name("III")
                        .description("Pop-2019")
                        .artist("BANKS")
                        .createDateTime(LocalDateTime.now())
                        .rank(0)
                        .build(),
                MusicAlbumModel.builder()
                        .id(3)
                        .name("Solutions")
                        .description("Alternative-2019")
                        .artist("K.Flay")
                        .createDateTime(LocalDateTime.now())
                        .rank(0)
                        .build(),
                MusicAlbumModel.builder()
                        .id(4)
                        .name("ERYS Deluxe")
                        .description("Hip-hop-2019")
                        .artist("Eminem")
                        .createDateTime(LocalDateTime.now())
                        .rank(0)
                        .build());
    }

    public List<MusicAlbumModel> getMusicAlbums() {

        return MUSIC_ALBUMS;
    }
}
