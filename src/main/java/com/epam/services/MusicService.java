package com.epam.services;

import com.epam.dao.MusicRepository;
import com.epam.models.MusicAlbumModel;
import com.epam.models.MusicModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicService {

    @Resource
    private MusicRepository musicRepository;

    public List<MusicAlbumModel> getMusicAlbums() {
        return musicRepository.getMusicAlbums();
    }

    public List<MusicModel> getMusicBy(Integer albumId) {
        return musicRepository.getMusicBy(albumId);
    }

    public MusicAlbumModel getMusicAlbumBy(Integer albumId) {
        return musicRepository.getMusicAlbumBy(albumId);
    }

    public void addNewAlbumInfo(String albumName, String albumDescription) {
        musicRepository.addNewAlbumInfo(albumName, albumDescription);
    }
}
