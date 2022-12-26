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
public class AuthorRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;

    public AuthorRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
