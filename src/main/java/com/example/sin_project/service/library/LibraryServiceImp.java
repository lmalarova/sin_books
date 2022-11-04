package com.example.sin_project.service.library;

import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Library;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImp implements LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImp(LibraryRepository LibraryRepository) {
        this.libraryRepository = LibraryRepository;
    }

    @Override
    public Library findById(Long id){
        if(id == null)
            throw new FieldMissingException();
        return libraryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Book> addBook(Book book) {
        if(book == null){
            throw new FieldMissingException();
        }
        Library library = book.getLibrary();
        library.getBooks().add(book);
        this.libraryRepository.save(library);
        return library.getBooks();
    }

    public void save(Library library) {
        this.libraryRepository.save(library);
    }
}
