package com.example.sin_project.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibraryRequest {
    @NotNull
    private String name;

    public LibraryRequest(String name) {
        this.name = name;
    }
}
