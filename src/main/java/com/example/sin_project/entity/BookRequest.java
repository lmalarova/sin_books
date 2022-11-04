package com.example.sin_project.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class BookRequest {
    private String ISBN;
    private String name;
    private Date published;
    private Author author;
    private Library library;
}
