package com.example.sin_project.entity;

import com.example.sin_project.dto.request.ContractRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
public class Contract extends AbstractEntity {
    @JsonIgnore
    @ManyToOne
    private Author author;

    @JsonIgnore
    @ManyToOne
    private PublishingHouse publishingHouse;

    private String content;

    public Contract(ContractRequest request) {
        this.name = request.getName();
        this.content = request.getContent();
    }
}
