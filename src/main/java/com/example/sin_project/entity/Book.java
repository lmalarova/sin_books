package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter
public class Book {

    @Column(unique = true)
    @NotNull
    private String ISBN;
    private String name;
    private Date published;
    @Id
    protected Long id;

    @ManyToMany
    List<Author> authors;

}
