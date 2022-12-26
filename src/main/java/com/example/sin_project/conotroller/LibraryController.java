package com.example.sin_project.conotroller;

import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.LibraryDTO;
import com.example.sin_project.dto.request.LibraryRequest;
import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.service.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;
    private final DTOMapper dtoMapper;

    @Autowired
    public LibraryController(LibraryService libraryService, DTOMapper dtoMapper) {
        this.libraryService = libraryService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibraryDTO> create(@RequestBody LibraryRequest request) {
        return ResponseEntity.ok(dtoMapper.libraryToDto(libraryService.create(request)));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibraryDTO> addBook(@PathVariable("id") Long libraryId, @RequestBody BookIdRequest request) {
        return ResponseEntity.ok(dtoMapper.libraryToDto(libraryService.addBook(libraryId, request)));
    }
}
