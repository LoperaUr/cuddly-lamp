package com.anbq.cuddlylamp.application.handler;

import com.anbq.cuddlylamp.domain.api.IUserServicePort;
import com.anbq.cuddlylamp.application.dto.req.UserRequest;
import com.anbq.cuddlylamp.application.dto.res.UserResponse;
import com.anbq.cuddlylamp.application.mapper.UserRequestMapper;
import com.anbq.cuddlylamp.application.mapper.UserResponseMapper;
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
