package com.example.sin_project.entity;

import com.example.sin_project.dto.request.PublishingHouseRequest;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class PublishingHouse extends AbstractEntity {

    @OneToMany
    private List<Book> books;

    @OneToMany
    List<Contract> contracts;

    public PublishingHouse(PublishingHouseRequest request) {
        this();
        this.name = request.getName();
    }
}
