package com.epam.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Builder
@Getter
@Setter
public abstract class MediaProductModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "createDateTime")
    private LocalDateTime createDateTime;
}
