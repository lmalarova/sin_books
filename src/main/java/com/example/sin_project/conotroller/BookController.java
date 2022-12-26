package com.example.sin_project.conotroller;

import com.example.sin_project.dto.BookDTO;
import com.example.sin_project.dto.DTOMapper;
import com.example.sin_project.dto.request.BookRequest;
import com.example.sin_project.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private final DTOMapper dtoMapper;

    @Autowired
    public BookController(BookService bookService, DTOMapper dtoMapper) {
        this.bookService = bookService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.bookToDto(bookService.findById(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> create(@RequestBody BookRequest request) {
        return ResponseEntity.ok(dtoMapper.bookToDto(bookService.create(request)));
    }

}
