package com.epam.converters;

import com.epam.dto.AudioBooksAlbumDto;
import com.epam.models.AudioBookModel;
import org.springframework.core.convert.converter.Converter;

public class AudioBooksAlbumConverter implements Converter<AudioBookModel, AudioBooksAlbumDto> {
    @Override
    public AudioBooksAlbumDto convert(AudioBookModel audioBookModel) {
        return AudioBooksAlbumDto.builder()
                .name(audioBookModel.getName())
                .description(audioBookModel.getDescription())
                .build();
    }
}
