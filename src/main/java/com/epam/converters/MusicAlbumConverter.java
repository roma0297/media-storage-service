package com.epam.converters;

import com.epam.dto.MusicAlbumDto;
import com.epam.models.MusicAlbumModel;
import org.springframework.core.convert.converter.Converter;

public class MusicAlbumConverter implements Converter<MusicAlbumModel, MusicAlbumDto> {
    @Override
    public MusicAlbumDto convert(MusicAlbumModel musicAlbumModel){
        return new MusicAlbumDto(musicAlbumModel.getName(), musicAlbumModel.getDescription());
    }
}
