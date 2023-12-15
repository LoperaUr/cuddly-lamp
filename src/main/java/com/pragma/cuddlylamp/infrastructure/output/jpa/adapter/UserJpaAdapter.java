package com.pragma.cuddlylamp.infrastructure.output.jpa.adapter;

import com.pragma.cuddlylamp.domain.model.User;
import com.pragma.cuddlylamp.domain.spi.IUserPersistencePort;
import com.pragma.cuddlylamp.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.pragma.cuddlylamp.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User saveUser(User user) {
        var userEntity = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toModel(userEntity);

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
