package com.example.todo.domain.global.common;

import com.example.todo.domain.todo.dto.TodoCreationResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommonResponse<T> {

    private final String message;

    private final T payload;

    public static <T> CommonResponse<T> of(String message, T payload) {
        return new CommonResponse<>(message, payload);
    }
}
