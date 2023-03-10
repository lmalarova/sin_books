package com.example.sin_project.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.sin_project.entity.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
