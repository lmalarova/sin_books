package com.example.sin_project.service.publishingHouse;

import com.example.sin_project.entity.*;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.PublishingHouseRepository;
import com.example.sin_project.service.author.AuthorServiceImp;
import com.example.sin_project.service.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PublishingHouseServiceImp implements PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private AuthorServiceImp authorService;

    @Autowired
    public PublishingHouseServiceImp(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    @Override
    public PublishingHouse findById(Long id){
        if(id == null)
            throw new FieldMissingException();
        return publishingHouseRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Book publishBook(BookRequest book) {
        if(book == null){
            throw new FieldMissingException();
        }
        Book newBook = new Book(book);
        authorService.addBook(newBook);
        libraryService.addBook(newBook);
        return newBook;
    }

    @Override
    public void addContract(Contract contract) {
        PublishingHouse publishingHouse = contract.getPublishingHouse();

        if(publishingHouse.getContracts() == null) {
            publishingHouse.setContracts(new ArrayList<>());
        }
        publishingHouse.getContracts().add(contract);
        this.publishingHouseRepository.save(publishingHouse);
    }
}
