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
public class AuthorDTO extends AbstractDTO {
    private String email;
    private List<Book> books;
    private List<Contract> contracts;

    public AuthorDTO(AuthorDTO dto) {
        super(dto);
        email = dto.getEmail();
        books = dto.getBooks();
        contracts = dto.getContracts();
    }

    @Override
    public AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        return new AuthorDTO(this);
    }
}
