package com.epam.facades;

import com.epam.dto.MusicAlbumDto;
import com.epam.dto.MusicModelDto;
import com.epam.forms.MusicAlbumForm;
import com.epam.forms.MusicForm;
import com.epam.services.MediaStorageService;
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
    @Resource
    private MediaStorageService musicStorageService;

    public List<MusicAlbumDto> getMusicAlbums() {
        return musicService.getMusicAlbums().stream()
                .map(musicAlbum -> conversionService.convert(musicAlbum, MusicAlbumDto.class))
                .collect(Collectors.toList());
    }

    public List<MusicModelDto> getMusicBy(Integer albumId) {
        return musicService.getMusicBy(albumId).stream()
                .map(music -> conversionService.convert(music, MusicModelDto.class))
                .collect(Collectors.toList());
    }

    public MusicAlbumDto getMusicAlbumBy(Integer albumId) {
        return conversionService.convert(musicService.getMusicAlbumBy(albumId), MusicAlbumDto.class);
    }

    public void saveNewAlbum(MusicAlbumForm musicAlbumForm) {
        musicService.addNewAlbumInfo(musicAlbumForm.getName(), musicAlbumForm.getDescription());
        musicStorageService.saveFiles(musicAlbumForm.getFiles(), musicAlbumForm.getName());
    }

    public void saveNewMusic(Integer albumId, MusicForm musicForm) {
        String albumName = musicService.getMusicAlbumBy(albumId).getName();
        musicStorageService.saveFiles(musicForm.getFiles(), albumName);
    }
}
