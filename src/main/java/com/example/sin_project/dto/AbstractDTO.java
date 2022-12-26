package com.example.sin_project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractDTO implements Cloneable{

    private Long id;
    private String name;

    public AbstractDTO(AbstractDTO dto) {
        id = dto.getId();
        name = dto.getName();
    }

    protected AbstractDTO clone() throws CloneNotSupportedException {
        super.clone();
        throw new CloneNotSupportedException();
    }
}

