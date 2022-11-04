package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Column(unique = true)
    @NotNull
    private String ISBN;
    private String name;
    private Date published;
    @Id
    protected Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Library library;

    public Book(BookRequest bookRequest) {
        this.ISBN = bookRequest.getISBN();
        this.name = bookRequest.getName();
        this.published = bookRequest.getPublished();
        this.author = bookRequest.getAuthor();
        this.library = bookRequest.getLibrary();
    }
}
