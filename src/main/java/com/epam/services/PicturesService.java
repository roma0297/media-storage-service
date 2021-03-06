package com.epam.services;

import com.epam.models.PictureModel;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.epam.dao.PicturesRepository;
import com.epam.models.PictureAlbumModel;
import java.util.List;

@Service
public class PicturesService {
    @Resource
    private PicturesRepository picturesRepository;

    public List<PictureAlbumModel> getPictureAlbums() {
        return picturesRepository.getPictureAlbums();
    }

    public List<PictureModel> getPicturesBy(Integer albumId) {
        return picturesRepository.getPicturesBy(albumId);
    }

    public PictureAlbumModel getPictureAlbumBy(Integer albumId) {
        return picturesRepository.getPictureAlbumBy(albumId);
    }

    public void addNewAlbumInfo(String albumName, String albumDescription) {
        picturesRepository.addNewAlbumInfo(albumName, albumDescription);
    }
}
