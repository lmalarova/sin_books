package com.example.sin_project.service.author;

import com.example.sin_project.entity.*;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.AuthorRepository;
import com.example.sin_project.service.publishingHouse.PublishingHouseService;
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
            throw new FieldMissingException();
        return authorRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Book> addBook(Book book) {
        Author author = book.getAuthor();
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
