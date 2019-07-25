package com.epam.converters;

import com.epam.dto.AudioBooksAlbumDto;
import com.epam.models.AudioBooksModel;
import org.springframework.core.convert.converter.Converter;

public class AudioBooksAlbumConverter implements Converter<AudioBooksModel, AudioBooksAlbumDto> {
    @Override
    public AudioBooksAlbumDto convert(AudioBooksModel audioBooksModel) {
        return AudioBooksAlbumDto.builder()
                .id(audioBooksModel.getId())
                .name(audioBooksModel.getName())
                .description(audioBooksModel.getDescription())
                .build();
    }
}