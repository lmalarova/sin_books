package com.example.sin_project.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContractRequest {
    @NotNull
    private String name;
    @NotNull
    private Long authorId;
    @NotNull
    private Long publishingHouseId;
    @NotNull
    private String content;

    public ContractRequest(String name, Long authorId, Long publishingHouseId, String content) {
        this.name = name;
        this.authorId = authorId;
        this.publishingHouseId = publishingHouseId;
        this.content = content;
    }
}
