package com.example.sin_project.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.sin_project.entity.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findByFirstName(String firstName);
    List<Author> findBySurName(String surName);

}
