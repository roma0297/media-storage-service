package com.epam.forms;

import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class MediaAlbumForm {
    @NotEmpty(message = "{NotEmpty.pictureAlbumForm.name}")
    @Size(min=5, max=20, message = "{Size.pictureAlbumForm.name}")
    private String name;
    @Size(max=200, message = "{Size.pictureAlbumForm.description}")
    private String description;
    private List<MultipartFile> files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
