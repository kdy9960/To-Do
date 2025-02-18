package com.example.todo.domain.global.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // Todo

    TODO_NOT_FOUND(400, "할일 을 찾을 수 없습니다."),
    TODO_DESCRIPTION_REQUIRED(400, "작성된 내용이 없습니다.");

    private final int statusCode;

    private final String message;

    ErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
