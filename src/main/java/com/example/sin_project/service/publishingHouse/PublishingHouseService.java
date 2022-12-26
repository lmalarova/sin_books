package com.example.sin_project.service.publishingHouse;

import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.entity.Contract;
import com.example.sin_project.entity.PublishingHouse;
import com.example.sin_project.dto.request.PublishingHouseRequest;

public interface PublishingHouseService {
    PublishingHouse findById(Long id);

    PublishingHouse create(PublishingHouseRequest request);

    PublishingHouse publishBook(Long publishingHouseId, BookIdRequest bookId);

    void addContract(Contract contract);
}
