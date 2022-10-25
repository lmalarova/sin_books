package com.example.sin_project.repository;

import com.example.sin_project.entity.Book;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ManyToMany;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);
}
