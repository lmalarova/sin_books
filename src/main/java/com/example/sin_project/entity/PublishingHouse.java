package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity

@Getter
@Setter
public class PublishingHouse {
    @Column(unique = true)
    @NotNull
    @Id
    protected Long id;

    private String name;

    @OneToMany
    private List<Book> books;

    @OneToMany
    List<Contract> contracts;
}
