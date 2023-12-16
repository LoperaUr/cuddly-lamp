package com.anbq.cuddlylamp.application.handler;

import com.anbq.cuddlylamp.application.dto.req.UserRequest;
import com.anbq.cuddlylamp.application.dto.res.UserResponse;

public interface IUserHandler {

    UserResponse saveUser(UserRequest userRequest);
    UserResponse getUserById(Long id);

}
