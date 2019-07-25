package com.epam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MusicAlbumDto {
    private Integer id;
    private String name;
    private String description;
}
