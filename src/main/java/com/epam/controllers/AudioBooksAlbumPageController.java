package com.epam.controllers;

import com.epam.facades.AudioBooksFacade;
import com.epam.forms.AudioBookForm;
import com.epam.forms.AudioBooksForm;
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
public class AudioBooksAlbumPageController {
    @Resource
    private AudioBooksFacade audioBooksFacade;

    @GetMapping("/audio/audiobooks")
    public ModelAndView getAudioBooksPage() {
        return new ModelAndView("audiobooks")
                .addObject("audiobookAlbums", audioBooksFacade.getAudioBooks())
                .addObject("audiobookAlbumsForm", AudioBooksForm.builder().build());
    }

    @GetMapping("/audio/audiobooks/{albumId}")
    public ModelAndView getAudioBooksPage(@PathVariable Integer albumId) {
        return new ModelAndView("audiobookAlbum")
                .addObject("audiobookAlbumInfo", audioBooksFacade.getAudioBooksBy(albumId))
                .addObject("audiobookForm", new AudioBookForm(albumId))
                .addObject("audiobooks", audioBooksFacade.getAudioBookBy(albumId));
    }

    @PostMapping("/audio/audiobooks")
    public ModelAndView saveNewAlbum(@Valid AudioBooksForm audioBooksForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            audioBooksFacade.saveNewAlbum(audioBooksForm);
            return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/audio/audiobooks");
        }
        return new ModelAndView().addObject("audiobookAlbums", audioBooksFacade.getAudioBooks());
    }

    @PostMapping("/audio/audiobooks/{albumId}")
    public ModelAndView saveNewAudioBook(@PathVariable Integer albumId, AudioBookForm audioBookForm) {
        audioBooksFacade.saveNewAudioBook(albumId, audioBookForm);
        return new ModelAndView(UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/audio/audiobooks/" + albumId);
    }
}
