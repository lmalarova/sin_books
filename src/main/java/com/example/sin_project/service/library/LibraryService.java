package com.example.sin_project.service.library;

import com.example.sin_project.dto.request.LibraryRequest;
import com.example.sin_project.dto.request.BookIdRequest;
import com.example.sin_project.entity.Library;

public interface LibraryService {
    Library findById(Long id);
    Library create(LibraryRequest request);
    Library addBook(Long libraryId, BookIdRequest request);
}
