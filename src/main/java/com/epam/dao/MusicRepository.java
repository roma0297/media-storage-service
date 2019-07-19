package com.epam.dao;

import com.epam.models.MusicAlbumModel;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class MusicRepository {

    private static final List<MusicAlbumModel> MUSIC_ALBUMS;

    static{
        MUSIC_ALBUMS = Arrays.asList(
                new MusicAlbumModel(1, "No.6 Collaborations Project", "Ed Sheeran", "Pop-2019", 0, LocalDateTime.now() ),
                new MusicAlbumModel(2, "III", "BANKS", "Alternative-2019", 0, LocalDateTime.now()),
                new MusicAlbumModel(3, "Solutions", "K.Flay", "Alternative-2019", 0, LocalDateTime.now()),
                new MusicAlbumModel(4, "ERYS Deluxe", "Jaden", "Hip-hop-2019", 0, LocalDateTime.now())
        );
    }

    public List<MusicAlbumModel> getMusicAlbums(){

        return MUSIC_ALBUMS;
    }
}
