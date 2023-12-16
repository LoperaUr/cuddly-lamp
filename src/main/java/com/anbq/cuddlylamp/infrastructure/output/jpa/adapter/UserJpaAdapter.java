package com.anbq.cuddlylamp.infrastructure.output.jpa.adapter;

import com.anbq.cuddlylamp.infrastructure.output.jpa.repository.IUserRepository;
import com.anbq.cuddlylamp.domain.model.User;
import com.anbq.cuddlylamp.domain.spi.IUserPersistencePort;
import com.anbq.cuddlylamp.infrastructure.output.jpa.mapper.UserEntityMapper;
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
