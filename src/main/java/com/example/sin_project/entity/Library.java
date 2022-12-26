package com.example.sin_project.entity;

import com.example.sin_project.dto.request.LibraryRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Library extends AbstractEntity {
    @OneToMany
    private List<Book> books;

    public Library(LibraryRequest request) {
        this();
        this.name = request.getName();
    }
}
