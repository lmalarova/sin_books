package com.example.sin_project.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublishingHouseRequest {
    @NotNull
    private String name;

    public PublishingHouseRequest(String name) {
        this.name = name;
    }
}