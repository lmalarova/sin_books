package com.example.sin_project.dto;

import com.example.sin_project.entity.Author;
import com.example.sin_project.entity.PublishingHouse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO extends AbstractDTO {

    private String ISBN;
    private Date published;
    private Author author;
    private PublishingHouse publishingHouse;

    public BookDTO(BookDTO dto) {
        super(dto);
        ISBN = dto.getISBN();
        published = (Date) dto.getPublished().clone();
        author = dto.getAuthor();
        publishingHouse = dto.getPublishingHouse();
    }

    public Date getPublished() {
        return (Date) published.clone();
    }

    public void setPublished(Date published) {
        this.published = (Date) published.clone();
    }

    @Override
    public AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        return new BookDTO(this);
    }
}
