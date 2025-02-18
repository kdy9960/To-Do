package com.example.todo.domain.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final int statusCode;

    public  CustomException(ErrorCode errorcode) {
        super(errorcode.getMessage());
        this.statusCode = errorcode.getStatusCode();
    }

}
