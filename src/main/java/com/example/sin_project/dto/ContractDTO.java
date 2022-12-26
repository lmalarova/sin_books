package com.example.sin_project.dto;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.PublishingHouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO extends AbstractDTO {
    private Author author;
    private PublishingHouse publishingHouse;
    private String content;

    public ContractDTO(ContractDTO dto) {
        super(dto);
        author = dto.getAuthor();
        publishingHouse = dto.getPublishingHouse();
        content = dto.getContent();
    }

    @Override
    public AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        return new ContractDTO(this);
    }
}
