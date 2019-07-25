package com.epam.converters;

import com.epam.dto.MusicModelDto;
import com.epam.models.MusicModel;
import org.springframework.core.convert.converter.Converter;

public class MusicConverter implements Converter<MusicModel, MusicModelDto>{
    @Override
    public MusicModelDto convert(MusicModel musicModel)
    {
        return MusicModelDto.builder()
                .originalName(musicModel.getOriginalName())
                .fileSystemPath(musicModel.getFileSystemPath())
                .build();
    }
}
