package com.epam.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class MusicForm {
    private Integer albumId;
    private List<MultipartFile> files;

    @Builder
    public MusicForm(Integer albumId) {
        this.albumId = albumId;
    }
}
