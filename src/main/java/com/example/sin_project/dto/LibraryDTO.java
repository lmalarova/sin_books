package com.example.sin_project.dto;

import com.example.sin_project.entity.Book;
import com.example.sin_project.entity.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LibraryDTO extends AbstractDTO {

    private List<Book> books;

    public LibraryDTO(LibraryDTO dto) {
        super(dto);
        books = dto.getBooks();
    }
    @Override
    public AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        return new LibraryDTO(this);
    }
}
