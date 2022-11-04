package com.example.sin_project.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractRequest {
    private Author author;
    private PublishingHouse publishingHouse;
    private String content;
}
