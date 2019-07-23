package com.epam.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class PictureForm {
    private Integer albumId;
    private List<MultipartFile> files;

    @Builder
    public PictureForm(Integer albumId) {
        this.albumId = albumId;
    }
}
