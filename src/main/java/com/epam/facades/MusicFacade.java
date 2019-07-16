package com.epam.facades;

import com.epam.dto.MusicAlbumDto;
import com.epam.services.MusicService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicFacade {

    @Resource
    private MusicService musicService;
    @Resource
    private ConversionService conversionService;

    public List<MusicAlbumDto> getMusicAlbums(){
        return musicService.getMusicAlbums().stream()
                .map(musicAlbums -> conversionService.convert(musicAlbums, MusicAlbumDto.class))
                .collect(Collectors.toList());
    }
}
