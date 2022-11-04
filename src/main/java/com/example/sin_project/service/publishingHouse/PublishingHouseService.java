package com.example.sin_project.service.publishingHouse;

import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.BookRequest;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.PublishingHouse;

public interface PublishingHouseService {
    PublishingHouse findById(Long id);

    Book publishBook(BookRequest book);

    void addContract(Contract contract);
}
