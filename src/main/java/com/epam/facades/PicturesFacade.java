package com.epam.facades;

import com.epam.dto.PictureAlbumDto;
import com.epam.dto.PictureModelDto;
import com.epam.forms.PictureAlbumForm;
import com.epam.forms.PictureForm;
import com.epam.services.MediaStorageService;
import com.epam.services.PicturesService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PicturesFacade {
    @Resource
    private PicturesService pictureService;
    @Resource
    private ConversionService conversionService;
    @Resource
    private MediaStorageService pictureStorageService;

    public List<PictureAlbumDto> getPictureAlbums() {
        return pictureService.getPictureAlbums().stream()
                .map(pictureAlbum -> conversionService.convert(pictureAlbum, PictureAlbumDto.class))
                .collect(Collectors.toList());
    }

    public List<PictureModelDto> getPicturesBy(Integer albumId) {
        return pictureService.getPicturesBy(albumId).stream()
                .map(picture -> conversionService.convert(picture, PictureModelDto.class))
                .collect(Collectors.toList());
    }

    public PictureAlbumDto getPictureAlbumBy(Integer albumId) {
        return conversionService.convert(pictureService.getPictureAlbumBy(albumId), PictureAlbumDto.class);
    }

    public void saveNewAlbum(PictureAlbumForm pictureAlbumForm) {
        pictureService.addNewAlbumInfo(pictureAlbumForm.getName(), pictureAlbumForm.getDescription());
        pictureStorageService.saveFiles(pictureAlbumForm.getFiles(), pictureAlbumForm.getName());
    }

    public void saveNewPictures(Integer albumId, PictureForm pictureForm) {
        String albumName = pictureService.getPictureAlbumBy(albumId).getName();
        pictureStorageService.saveFiles(pictureForm.getFiles(), albumName);
    }
}
