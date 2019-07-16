package com.epam.services;

import com.epam.models.AudioBooksAlbumModel;
import com.epam.dao.AudioBooksRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AudioBooksService {

    @Resource
    private AudioBooksRepository audioBooksRepository;

    public List<AudioBooksAlbumModel> getAudioBooksAlbums(){
        return audioBooksRepository.getAudioBooksAlbum();
    }
}
