package com.epam.facades;

import com.epam.dto.AudioBooksAlbumDto;
import com.epam.services.AudioBooksService;
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

    public List<AudioBooksAlbumDto> getAudioBooksAlbums() {
        return audioBooksService.getAudioBooksAlbums().stream()
                .map(audioBooksAlbums -> conversionService.convert(audioBooksAlbums, AudioBooksAlbumDto.class))
                .collect(Collectors.toList());
    }
}
