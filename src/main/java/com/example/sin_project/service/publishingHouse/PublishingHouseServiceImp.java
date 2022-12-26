package com.example.sin_project.service.publishingHouse;

import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.dto.request.PublishingHouseRequest;
import com.example.sin_project.entity.*;
import com.example.sin_project.exception.FieldMissingException;
import com.example.sin_project.exception.NotFoundException;
import com.example.sin_project.repository.PublishingHouseRepository;
import com.example.sin_project.service.book.BookServiceImp;
import com.example.sin_project.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PublishingHouseServiceImp implements PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    private ContractService contractService;

    @Autowired
    private BookServiceImp bookService;

    @Autowired
    public PublishingHouseServiceImp(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    @Override
    public PublishingHouse findById(Long id){
        if(id == null)
            throw new FieldMissingException("ID_MISSING");
        return publishingHouseRepository.findById(id).orElseThrow(() ->new NotFoundException("PUBLISHING_HOUSE_NOT_FOUND"));
    }

    @Override
    public PublishingHouse create(PublishingHouseRequest request) {
        return this.publishingHouseRepository.save(new PublishingHouse(request));
    }

    @Override
    public PublishingHouse publishBook(Long publishingHouseId, BookIdRequest request) {
        Book newBook = this.bookService.findById(request.getBookId());
        if(newBook == null) {
            throw new NotFoundException("BOOK_NOT_FOUND");
        }
        // check if author has contract with publishing house
        this.contractService.findByAuthorAndPublishingHouse(newBook.getAuthor().getId(), publishingHouseId);

        // add book to publishing house
        PublishingHouse publishingHouse = this.publishingHouseRepository.getById(publishingHouseId);
        if(publishingHouse == null) {
            throw new NotFoundException("PUBLISHING_HOUSE_NOT_FOUND");
        }
        newBook.setPublishingHouse(publishingHouse);
        if(publishingHouse.getBooks() == null){
            publishingHouse.setBooks(new ArrayList<>());
        }
        publishingHouse.getBooks().add(newBook);
        this.bookService.save(newBook);
        this.publishingHouseRepository.save(publishingHouse);

        return publishingHouse;
    }

    @Override
    public void addContract(Contract contract) {
        PublishingHouse publishingHouse = contract.getPublishingHouse();
        if(publishingHouse == null) {
            throw new NotFoundException("PUBLISHING_HOUSE_NOT_FOUND");
        }
        if(publishingHouse.getContracts() == null) {
            publishingHouse.setContracts(new ArrayList<>());
        }
        publishingHouse.getContracts().add(contract);
        this.publishingHouseRepository.save(publishingHouse);
    }

    public void save(PublishingHouse publishingHouse) {
        this.publishingHouseRepository.save(publishingHouse);
    }
}
