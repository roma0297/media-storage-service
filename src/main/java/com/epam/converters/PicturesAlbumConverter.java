package com.epam.converters;

import com.epam.dto.PictureAlbumDto;
import com.epam.models.PictureAlbumModel;
import org.springframework.core.convert.converter.Converter;

public class PicturesAlbumConverter implements Converter<PictureAlbumModel, PictureAlbumDto> {
    @Override
    public PictureAlbumDto convert(PictureAlbumModel pictureAlbumModel) {
        return new PictureAlbumDto(pictureAlbumModel.getName(), pictureAlbumModel.getDescription());
    }
}
