package com.epam.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class PictureModelDto {
    private String originalName;
    private String fileSystemPath;
}
