package com.example.sin_project.service.author;

import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Contract;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);
    Author create(AuthorRequest request);
    List<Book> addBookToAuthor(Book book);
    void addContract(Contract contract);
}
