package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
public class Author {

    @Column
    @Id
    protected Long id;
    @NotNull
    private String firstName;
    private String surName;
    private String email;

    @OneToMany
    List<Book> books;

    @OneToMany
    List<Contract> contracts;
}
