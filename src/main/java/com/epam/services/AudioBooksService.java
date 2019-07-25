package com.epam.services;

import com.epam.dao.AudioBooksRepository;
import com.epam.models.AudioBookModel;
import com.epam.models.AudioBooksModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AudioBooksService {

    @Resource
    private AudioBooksRepository audioBooksRepository;

    public List<AudioBooksModel> getAudioBooks() {
        return audioBooksRepository.getAudioBooks();
    }

    public List<AudioBookModel> getAudioBookBy(Integer albumId) {
        return audioBooksRepository.getAudioBookBy(albumId);
    }

    public AudioBooksModel getAudioBooksBy(Integer albumId) {
        return audioBooksRepository.getAudioBooksBy(albumId);
    }

    public void addNewAlbumInfo(String albumName, String albumDescription, String writer) {
        audioBooksRepository.addNewAlbumInfo(albumName, albumDescription, writer);
    }
}
