package com.example.sin_project.service.library;

import com.example.sin_project.dto.request.LibraryRequest;
import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Library;
import com.example.sin_project.exception.FieldInvalidException;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.LibraryRepository;
import com.example.sin_project.service.book.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LibraryServiceImp implements LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    private BookServiceImp bookService;

    @Autowired
    public LibraryServiceImp(LibraryRepository LibraryRepository) {
        this.libraryRepository = LibraryRepository;
    }

    @Override
    public Library findById(Long id){
        if(id == null)
            throw new FieldMissingException("ID_MISSING");
        return libraryRepository.findById(id).orElseThrow(() -> new NotFoundException("LIBRARY_NOT_FOUND"));
    }

    @Override
    public Library create(LibraryRequest request) {
        return libraryRepository.save(new Library(request));
    }

    @Override
    public Library addBook(Long libraryId, BookIdRequest request) {
        int count = 0;
        List<String> names = new ArrayList<>();
        Book book = this.bookService.findById(request.getBookId());
        Library library = this.libraryRepository.findById(libraryId).orElseThrow(() -> new NotFoundException("LIBRARY_NOT_FOUND"));
        if(library.getBooks() == null){
            library.setBooks(new ArrayList<>());
        }

        // count
        List<Book> books = library.getBooks();
        for(Book temp_book : books) {
            names.add(temp_book.getName());
        }
        for(String name : names) {
            count = Collections.frequency(names, book.getName());
        }
        if(count > 5) {
            throw new FieldInvalidException("Max 5 same books in library allowed");
        }
        library.getBooks().add(book);
        this.libraryRepository.save(library);
        return library;
    }

    public void save(Library library) {
        this.libraryRepository.save(library);
    }
}
