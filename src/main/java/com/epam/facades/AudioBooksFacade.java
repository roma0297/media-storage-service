package com.epam.facades;

import com.epam.dto.AudioBooksAlbumDto;
import com.epam.dto.AudioBooksModelDto;
import com.epam.forms.AudioBookForm;
import com.epam.forms.AudioBooksForm;
import com.epam.services.AudioBooksService;
import com.epam.services.MediaStorageService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AudioBooksFacade {
    @Resource
    private AudioBooksService audioBooksService;
    @Resource
    private ConversionService conversionService;
    @Resource
    private MediaStorageService audioStorageService;

    public List<AudioBooksAlbumDto> getAudioBooks() {
        return audioBooksService.getAudioBooks().stream()
                .map(audiobookAlbum -> conversionService.convert(audiobookAlbum, AudioBooksAlbumDto.class))
                .collect(Collectors.toList());
    }

    public List<AudioBooksModelDto> getAudioBookBy(Integer albumId) {
        return audioBooksService.getAudioBookBy(albumId).stream()
                .map(audiobook -> conversionService.convert(audiobook, AudioBooksModelDto.class))
                .collect(Collectors.toList());
    }

    public AudioBooksAlbumDto getAudioBooksBy(Integer albumId) {
        return conversionService.convert(audioBooksService.getAudioBooksBy(albumId), AudioBooksAlbumDto.class);
    }

    public void saveNewAlbum(AudioBooksForm audioBooksForm) {
        audioBooksService.addNewAlbumInfo(audioBooksForm.getName(), audioBooksForm.getDescription(), audioBooksForm.getWriter());
        audioStorageService.saveFiles(audioBooksForm.getFiles(), audioBooksForm.getName());
    }

    public void saveNewAudioBook(Integer albumId, AudioBookForm audioBookForm) {
        String albumName = audioBooksService.getAudioBooksBy(albumId).getName();
        audioStorageService.saveFiles(audioBookForm.getFiles(), albumName);
    }
}