package com.epam.facades;

import com.epam.converters.MusicAlbumConverter;
import com.epam.dto.MusicAlbumDto;
import com.epam.services.MusicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicFacade {

    @Resource
    private MusicService musicService;

    @Resource
    private MusicAlbumConverter musicAlbumConverter;

    public List<MusicAlbumDto> getMusicAlbums(){
        return musicService.getMusicAlbums().stream()
                .map(musicAlbums -> musicAlbumConverter.convert(musicAlbums))
                .collect(Collectors.toList());
    }
}
