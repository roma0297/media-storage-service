package com.epam.controllers;

import com.epam.facades.PicturesFacade;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PictureAlbumsPageController {
    @Resource
    private PicturesFacade picturesFacade;

    @GetMapping("/pictures")
    public ModelAndView getPictureAlbumsPage() {
        return new ModelAndView("pictures")
                .addObject("pictureAlbums", picturesFacade.getPictureAlbums());
    }
}
