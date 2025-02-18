package com.example.todo.domain.global.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    @Schema(description = "에러 메시지", example = "할일을 찾을 수 없습니다.")
    private String message;

    public static ErrorResponse of(String message) {

        return ErrorResponse.builder()
                .message(message)
                .build();
    }

}
