package com.epam.controllers;

import com.epam.facades.MusicFacade;
import com.epam.forms.MusicAlbumForm;
import com.epam.forms.MusicForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class MusicAlbumsPageController {

    @Resource
    private MusicFacade musicFacade;

    @GetMapping("/audio/music")
    public ModelAndView getMusicAlbumsPage() {
        return new ModelAndView("music")
                .addObject("musicAlbums", musicFacade.getMusicAlbums())
                .addObject("musicAlbumForm", MusicAlbumForm.builder().build());
    }

    @GetMapping("/audio/music/{albumId}")
    public ModelAndView getMusicAlbumsPage(@PathVariable Integer albumId) {
        return new ModelAndView("musicAlbum")
                .addObject("musicAlbumInfo", musicFacade.getMusicAlbumBy(albumId))
                .addObject("musicForm", new MusicForm(albumId))
                .addObject("music", musicFacade.getMusicBy(albumId));
    }

    @PostMapping("/audio/music")
    public ModelAndView saveNewAlbum(@Valid MusicAlbumForm musicAlbumForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            musicFacade.saveNewAlbum(musicAlbumForm);
            return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/audio/music");
        }
        return new ModelAndView().addObject("musicAlbums", musicFacade.getMusicAlbums());
    }

    @PostMapping("/audio/music/{albumId}")
    public ModelAndView saveNewMusic(@PathVariable Integer albumId, MusicForm musicForm) {
        musicFacade.saveNewMusic(albumId, musicForm);
        return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/audio/music/" + albumId);
    }
}
