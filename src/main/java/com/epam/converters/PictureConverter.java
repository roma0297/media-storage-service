package com.epam.converters;

import com.epam.dto.PictureModelDto;
import com.epam.models.PictureModel;
import org.springframework.core.convert.converter.Converter;

public class PictureConverter implements Converter<PictureModel, PictureModelDto> {
    @Override
    public PictureModelDto convert(PictureModel pictureModel) {
        return PictureModelDto.builder()
                .originalName(pictureModel.getOriginalName())
                .fileSystemPath(pictureModel.getFileSystemPath())
                .build();
    }
}
