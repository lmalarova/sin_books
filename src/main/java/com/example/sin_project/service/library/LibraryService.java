package com.example.sin_project.service.library;

import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Library;

import java.util.List;

public interface LibraryService {
    Library findById(Long id);
    List<Book> addBook(Book book);
}
