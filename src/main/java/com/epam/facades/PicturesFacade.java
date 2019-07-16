package com.epam.facades;

import com.epam.dto.PictureAlbumDto;
import com.epam.services.PicturesService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PicturesFacade {

    @Resource
    private PicturesService picturesService;
    @Resource
    private ConversionService conversionService;

    public List<PictureAlbumDto> getPictureAlbums() {
        return picturesService.getPictureAlbums().stream()
                .map(pictureAlbum -> conversionService.convert(pictureAlbum, PictureAlbumDto.class))
                .collect(Collectors.toList());
    }
}
