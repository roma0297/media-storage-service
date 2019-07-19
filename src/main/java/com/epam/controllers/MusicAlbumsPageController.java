package com.epam.controllers;

import com.epam.facades.MusicFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;

@Controller
public class MusicAlbumsPageController {

    @Resource
    private MusicFacade musicFacade;

    @GetMapping("/audio/music")
    public ModelAndView getMusicAlbumsPage() {
        return new ModelAndView("music")
                .addObject("musicAlbums", musicFacade.getMusicAlbums());
    }
}
