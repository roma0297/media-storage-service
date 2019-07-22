package com.epam.converters;

import com.epam.dto.AudioBooksAlbumDto;
import com.epam.models.AudioBooksAlbumModel;
import org.springframework.core.convert.converter.Converter;

public class AudioBooksAlbumConverter implements Converter<AudioBooksAlbumModel, AudioBooksAlbumDto> {
    @Override
    public AudioBooksAlbumDto convert(AudioBooksAlbumModel audioBooksAlbumModel){
        return new AudioBooksAlbumDto(audioBooksAlbumModel.getName(), audioBooksAlbumModel.getDescription());
    }
}
