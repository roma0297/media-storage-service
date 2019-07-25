package com.epam.converters;

import com.epam.dto.AudioBooksModelDto;
import com.epam.models.AudioBookModel;
import org.springframework.core.convert.converter.Converter;

public class AudioBookConverter  implements Converter<AudioBookModel, AudioBooksModelDto> {
    @Override
    public AudioBooksModelDto convert(AudioBookModel audioBookModel) {
        return AudioBooksModelDto.builder()
                .originalName(audioBookModel.getOriginalName())
                .fileSystemPath(audioBookModel.getFileSystemPath())
                .build();
    }
}