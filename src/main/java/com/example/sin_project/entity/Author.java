package com.example.sin_project.entity;

import com.example.sin_project.dto.request.AuthorRequest;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Author extends AbstractEntity {
    @NotNull
    private String email;

    @OneToMany
    List<Book> books;

    @OneToMany
    List<Contract> contracts;

    public Author(AuthorRequest request) {
        this();
        this.name = request.getName();
        this.email = request.getEmail();
    }

}
