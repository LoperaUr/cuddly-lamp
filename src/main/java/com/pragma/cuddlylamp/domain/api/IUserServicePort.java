package com.pragma.cuddlylamp.domain.api;

import com.pragma.cuddlylamp.domain.model.User;



public interface IUserServicePort {

    User saveUser(User user);
    User getUserById(Long id);

}
