package com.epam.controllers;

import com.epam.facades.AudioBooksFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

@Controller
public class AudioBooksAlbumPageController {

    @Resource
    private AudioBooksFacade audioBooksFacade;

    @GetMapping("/audio/audiobooks")
    public ModelAndView getAudioBooksAlbumPage() {
        return new ModelAndView("audiobooks")
                .addObject("audioBooksAlbums", audioBooksFacade.getAudioBooksAlbums());
    }
}
