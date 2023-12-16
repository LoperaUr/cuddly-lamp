package com.anbq.cuddlylamp.infrastructure.exceptionhandler;

import com.anbq.cuddlylamp.domain.exception.BodyInvalidException;
import com.anbq.cuddlylamp.domain.exception.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    public static final String MESSAGE = "message";

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.ROLE_NOT_FOUND.getMessage()));

    }

    @ExceptionHandler(BodyInvalidException.class)
    public ResponseEntity<Map<String, String>> handleBodyInvalidException(
            BodyInvalidException bodyInvalidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, bodyInvalidException.getMessage()));
    }
}
