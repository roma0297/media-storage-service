package com.epam.models;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter

public class AuthorityModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public AuthorityModel() {
    }

    public AuthorityModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
