package com.epam.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class PictureAlbumDto {
    private Integer id;
    private String name;
    private String description;
}
