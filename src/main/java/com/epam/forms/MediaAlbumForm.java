package com.epam.forms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class MediaAlbumForm {
    @NotEmpty(message = "{NotEmpty.AlbumForm.name}")
    @Size(min = 5, max = 20, message = "{Size.AlbumForm.name}")
    private String name;
    @Size(max = 200, message = "{Size.AlbumForm.description}")
    private String description;
    private List<MultipartFile> files;

    private String writer;
}
