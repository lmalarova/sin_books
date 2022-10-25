package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "authors")
    List<Book> books;
}
