package com.example.sin_project.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookIdRequest {
    @NotNull
    Long bookId;

    public BookIdRequest(Long bookId) {
        this.bookId = bookId;
    }
}
