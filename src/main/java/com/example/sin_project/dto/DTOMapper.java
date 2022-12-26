package com.example.sin_project.dto;

import com.example.sin_project.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    BookDTO bookToDto(Book book);
    PublishingHouseDTO publishingHouseToDto(PublishingHouse publishingHouse);
    AuthorDTO authorToDto(Author author);
    LibraryDTO libraryToDto(Library library);
    ContractDTO contractToDto(Contract contract);
}
