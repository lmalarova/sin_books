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
public class PublishingHouseDTO extends AbstractDTO {

    private List<Book> books;
    private List<Contract> contracts;

    public PublishingHouseDTO(PublishingHouseDTO dto) {
        super(dto);
        books = dto.getBooks();
        contracts = dto.getContracts();
    }
    @Override
    public AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        return new PublishingHouseDTO(this);
    }
}
