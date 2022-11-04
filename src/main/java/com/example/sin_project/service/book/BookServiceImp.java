package com.example.sin_project.service.book;

import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.BookRequest;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id){
        if(id == null)
            throw new FieldMissingException();
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void save(Book book) {
    this.bookRepository.save(book);
}
}
