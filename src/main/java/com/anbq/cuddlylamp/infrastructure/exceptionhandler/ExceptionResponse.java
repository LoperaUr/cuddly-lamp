package com.anbq.cuddlylamp.infrastructure.exceptionhandler;


import lombok.Getter;

@Getter
public enum ExceptionResponse {
    ROLE_NOT_FOUND("Role not found"),
    ;




    private final String message;
    ExceptionResponse(String message) {
        this.message = message;
    }

}
