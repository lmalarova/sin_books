package com.example.sin_project.controller;

import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.PublishingHouseDTO;
import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.dto.request.PublishingHouseRequest;
import com.example.sin_project.service.publishingHouse.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishingHouse")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;
    private final DTOMapper dtoMapper;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService, DTOMapper dtoMapper) {
        this.publishingHouseService = publishingHouseService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublishingHouseDTO> create(@RequestBody PublishingHouseRequest request) {
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.create(request)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublishingHouseDTO> publishBook(@PathVariable("id") Long publishingHouseId, @RequestBody BookIdRequest request) {
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.publishBook(publishingHouseId, request)));
    }
}
