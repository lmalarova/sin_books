package com.example.sin_project.entity;

import com.example.sin_project.dto.request.BookRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Book extends AbstractEntity{

    @Column(unique = true)
    @NotNull
    private String ISBN;
    private Date published;

    @JsonIgnore
    @ManyToOne
    private PublishingHouse publishingHouse;

    @JsonIgnore
    @ManyToOne
    private Author author;

    @JsonIgnore
    @ManyToOne
    private Library library;

    public Book(BookRequest request) {
        this();
        this.name = request.getName();
        this.ISBN = request.getISBN();
        this.setPublished(new Date());
    }

    public Date getPublished() {
        return (Date) published.clone();
    }

    public void setPublished(Date published) {
        this.published = (Date) published.clone();
    }

}
