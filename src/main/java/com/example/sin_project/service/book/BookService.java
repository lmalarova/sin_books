package com.example.sin_project.service.book;

import com.example.sin_project.entity.Book;
import com.example.sin_project.dto.request.BookRequest;

public interface BookService {
    Book findById(Long id);
    Book create (BookRequest bookRequest);
//    Book update(Long bookId, BookRequest request);
}
