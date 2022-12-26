package com.example.sin_project.service.book;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.Book;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.BookRepository;
import com.example.sin_project.service.author.AuthorService;
import com.example.sin_project.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(Long id){
        if(id == null)
            throw new FieldMissingException("ID_MISSING");
        return bookRepository.findById(id).orElseThrow(() ->new NotFoundException("BOOK_NOT_FOUND"));
    }

    @Override
    public Book create (BookRequest bookRequest) {
        if(bookRequest == null) {
            throw new FieldMissingException("BOOK_REQUEST_MISSING");
        }

        Book newBook = this.bookRepository.save(new Book(bookRequest));

        // set author of book
        Author author = authorService.findById(bookRequest.getAuthorId());
        if(author == null) {
            throw new NotFoundException("AUTHOR_NOT_FOUND");
        }
        newBook.setAuthor(author);
        this.bookRepository.save(newBook);
        authorService.addBookToAuthor(newBook);
        return newBook;
    }

    public void save(Book book) {
    this.bookRepository.save(book);
}
}
