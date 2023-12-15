package com.pragma.cuddlylamp.application.handler;

import com.pragma.cuddlylamp.application.dto.req.UserRequest;
import com.pragma.cuddlylamp.application.dto.res.UserResponse;

public interface IUserHandler {

    UserResponse saveUser(UserRequest userRequest);
    UserResponse getUserById(Long id);

}
