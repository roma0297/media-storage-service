package com.epam.controllers;

import com.epam.facades.PicturesFacade;
import com.epam.forms.PictureAlbumForm;
import com.epam.forms.PictureForm;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Controller
public class PictureAlbumsPageController {
    @Resource
    private PicturesFacade picturesFacade;

    @GetMapping("/pictures")
    public ModelAndView getPictureAlbumsPage() {
        return new ModelAndView("pictures")
                .addObject("pictureAlbums", picturesFacade.getPictureAlbums())
                .addObject("pictureAlbumForm", PictureAlbumForm.builder().build());
    }

    @GetMapping("/pictures/{albumId}")
    public ModelAndView getPictureAlbumsPage(@PathVariable Integer albumId) {
        return new ModelAndView("pictureAlbum")
                .addObject("albumInfo", picturesFacade.getPictureAlbumBy(albumId))
                .addObject("pictureForm", new PictureForm(albumId))
                .addObject("pictures", picturesFacade.getPicturesBy(albumId));
    }

    @PostMapping("/pictures")
    public ModelAndView saveNewAlbum(@Valid PictureAlbumForm pictureAlbumForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            picturesFacade.saveNewAlbum(pictureAlbumForm);
            return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/pictures");
        }
        return new ModelAndView().addObject("pictureAlbums", picturesFacade.getPictureAlbums());
    }

    @PostMapping("/pictures/{albumId}")
    public ModelAndView saveNewPictures(@PathVariable Integer albumId, PictureForm pictureForm) {
        picturesFacade.saveNewPictures(albumId, pictureForm);
        return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/pictures/" + albumId);
    }
}
