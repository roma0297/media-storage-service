package com.epam.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class AudioBooksModelDto {
    private String originalName;
    private String fileSystemPath;
}
