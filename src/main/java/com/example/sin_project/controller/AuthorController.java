package com.example.sin_project.controller;

import com.example.sin_project.dto.AuthorDTO;
import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.request.AuthorRequest;
import com.example.sin_project.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    private final DTOMapper dtoMapper;

    @Autowired
    public AuthorController(AuthorService authorService, DTOMapper dtoMapper) {
        this.authorService = authorService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorRequest request) {
        return ResponseEntity.ok(dtoMapper.authorToDto(authorService.create(request)));
    }
}
