package com.example.sin_project.service.author;

import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.dto.request.ContractRequest;
import com.example.sin_project.entity.*;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Long id){
        if(id == null)
            throw new FieldMissingException("ID_MISSING");
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException("AUTHOR_NOT_FOUND"));
    }

    @Override
    public Author create(AuthorRequest request) {
        return authorRepository.save(new Author(request));
    }

    @Override
    public List<Book> addBookToAuthor(Book book) {
        if(book == null) {
            throw new FieldMissingException("BOOK_MISSING");
        }
        Author author = book.getAuthor();
        if(author == null) {
            throw new NotFoundException("AUTHOR_NOT_FOUND");
        }
        if(author.getBooks() == null){
            author.setBooks(new ArrayList<>());
        }
        author.getBooks().add(book);
        this.authorRepository.save(author);
        return book.getAuthor().getBooks();
    }

    @Override
    public void addContract(Contract contract) {
        Author author = contract.getAuthor();

        if(author == null) {
            throw new NotFoundException("AUTHOR_NOT_FOUND");
        }
        if(author.getContracts() == null) {
            author.setContracts(new ArrayList<>());
        }
        author.getContracts().add(contract);
        this.authorRepository.save(author);
    }

    public void save(Author author) {
    this.authorRepository.save(author);
}
}
