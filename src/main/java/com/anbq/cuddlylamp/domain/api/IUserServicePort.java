package com.anbq.cuddlylamp.domain.api;

import com.anbq.cuddlylamp.domain.model.User;



public interface IUserServicePort {

    User saveUser(User user);
    User getUserById(Long id);

}
