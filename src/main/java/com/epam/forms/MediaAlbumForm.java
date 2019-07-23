package com.epam.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class MediaAlbumForm {
    @NotEmpty(message = "{NotEmpty.pictureAlbumForm.name}")
    @Size(min=5, max=20, message = "{Size.pictureAlbumForm.name}")
    private String name;
    @Size(max=200, message = "{Size.pictureAlbumForm.description}")
    private String description;
    private List<MultipartFile> files;
}
