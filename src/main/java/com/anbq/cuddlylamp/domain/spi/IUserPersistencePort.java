package com.anbq.cuddlylamp.domain.spi;

import com.anbq.cuddlylamp.domain.model.User;

public interface IUserPersistencePort {

    User saveUser(User user);
    User getUserById(Long id);
}
