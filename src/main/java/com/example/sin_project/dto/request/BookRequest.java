package com.example.sin_project.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class BookRequest {
    @NotNull
    private String ISBN;
    @NotNull
    private String name;
    @NotNull
    private Long authorId;

    public BookRequest(String ISBN, String name, Long authorId) {
        this.ISBN = ISBN;
        this.name = name;
        this.authorId = authorId;
    }
}
