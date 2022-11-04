package com.example.sin_project.service.author;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.ContractRequest;

import java.util.List;

public interface AuthorService {
    Author findById(Long id);
    List<Book> addBook(Book book);
    void addContract(Contract contract);
}
