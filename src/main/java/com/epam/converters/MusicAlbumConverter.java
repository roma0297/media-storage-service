package com.epam.converters;

import com.epam.dto.MusicAlbumDto;
import com.epam.models.MusicAlbumModel;
import org.springframework.core.convert.converter.Converter;

public class MusicAlbumConverter implements Converter<MusicAlbumModel, MusicAlbumDto> {
    @Override
    public MusicAlbumDto convert(MusicAlbumModel musicAlbumModel) {
        return MusicAlbumDto.builder()
                .id(musicAlbumModel.getId())
                .name(musicAlbumModel.getName())
                .description(musicAlbumModel.getDescription())
                .build();
    }
}
