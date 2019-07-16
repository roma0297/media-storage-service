package com.epam.facades;

import com.epam.converters.AudioBooksAlbumConverter;
import com.epam.dto.AudioBooksAlbumDto;
import com.epam.services.AudioBooksService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AudioBooksFacade {

    @Resource
    private AudioBooksService audioBooksService;

    @Resource
    private AudioBooksAlbumConverter audioBooksAlbumConverter;

    public List<AudioBooksAlbumDto> getAudioBooksAlbums(){
        return audioBooksService.getAudioBooksAlbums().stream()
                .map(audioBooksAlbums -> audioBooksAlbumConverter.convert(audioBooksAlbums))
                .collect(Collectors.toList());
    }
}
