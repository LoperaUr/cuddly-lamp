package com.pragma.cuddlylamp.application.handler;

import com.pragma.cuddlylamp.application.dto.req.UserRequest;
import com.pragma.cuddlylamp.application.dto.res.UserResponse;
import com.pragma.cuddlylamp.application.mapper.UserRequestMapper;
import com.pragma.cuddlylamp.application.mapper.UserResponseMapper;
import com.pragma.cuddlylamp.domain.api.IUserServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final PasswordEncoder passwordEncoder;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {

        var user = userRequestMapper.toModel(userRequest);
        user.setPasswordEncoded(passwordEncoder.encode(userRequest.getPassword()));
        user = userServicePort.saveUser(user);
        return userResponseMapper.toResponse(user);

    }

    @Override
    public UserResponse getUserById(Long id) {
        return userResponseMapper.toResponse(userServicePort.getUserById(id));
    }
}
