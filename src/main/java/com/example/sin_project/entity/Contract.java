package com.example.sin_project.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Contract {
    @Column(unique = true)
    @NotNull
    @Id
    protected Long id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private PublishingHouse publishingHouse;

    private String content;

    public Contract(ContractRequest request) {
        this.author = request.getAuthor();
        this.publishingHouse = request.getPublishingHouse();
        this.content = request.getContent();
    }
}
