package com.epam.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class MusicModelDto {
    private String originalName;
    private String fileSystemPath;
}
