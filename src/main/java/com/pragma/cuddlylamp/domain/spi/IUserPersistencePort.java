package com.pragma.cuddlylamp.domain.spi;

import com.pragma.cuddlylamp.domain.model.User;

public interface IUserPersistencePort {

    User saveUser(User user);
    User getUserById(Long id);
}
