package com.example.sin_project.exception;

import lombok.Getter;

@Getter
public class FieldMissingException extends RuntimeException{
    private final String errorCode;

    public FieldMissingException(String errorCode) {
        this.errorCode = errorCode;
    }
}
