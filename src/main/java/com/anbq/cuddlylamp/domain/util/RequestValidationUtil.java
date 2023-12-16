package com.anbq.cuddlylamp.domain.util;

import com.anbq.cuddlylamp.domain.exception.BodyInvalidException;
import com.anbq.cuddlylamp.domain.model.User;

import static org.springframework.util.Assert.hasText;

public final class RequestValidationUtil {

    public static void validateRequestBody(User userRequest) {
        try {
            hasText(userRequest.getName(), "Name must not be null or empty");
            hasText(userRequest.getLastName(), "Last name must not be null or empty");
            hasText(userRequest.getEmail(), "Email must not be null or empty");
            hasText(userRequest.getPassword(), "Password must not be null or empty");

        } catch (Exception e) {
            throw new BodyInvalidException(e.getMessage());
        }


    }



    private RequestValidationUtil() {
    }
}
