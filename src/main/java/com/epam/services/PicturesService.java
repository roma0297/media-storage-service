package com.epam.services;

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
}
