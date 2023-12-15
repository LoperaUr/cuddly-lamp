package com.pragma.cuddlylamp.domain.usecase;

import com.pragma.cuddlylamp.domain.api.IUserServicePort;
import com.pragma.cuddlylamp.domain.model.User;
import com.pragma.cuddlylamp.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    @Override
    public User saveUser(User user) {
        return userPersistencePort.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }
}
