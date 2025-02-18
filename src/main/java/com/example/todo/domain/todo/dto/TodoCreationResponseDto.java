package com.example.todo.domain.todo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoCreationResponseDto {

    private Long id;

    private String description;

    private boolean completed;

    private LocalDateTime createdAt;

}
