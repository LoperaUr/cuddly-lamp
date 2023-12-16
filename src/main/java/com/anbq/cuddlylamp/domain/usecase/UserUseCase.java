package com.anbq.cuddlylamp.domain.usecase;

import com.anbq.cuddlylamp.domain.api.IUserServicePort;
import com.anbq.cuddlylamp.domain.exception.RoleNotFoundException;
import com.anbq.cuddlylamp.domain.model.User;
import com.anbq.cuddlylamp.domain.spi.IRolePersistencePort;
import com.anbq.cuddlylamp.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import static com.anbq.cuddlylamp.domain.util.RequestValidationUtil.validateRequestBody;

@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;

    @Override
    public User saveUser(User user) {
        validateRequestBody(user);
        if (!rolePersistencePort.existsById(user.getRole().getId())) throw new RoleNotFoundException();


        return userPersistencePort.saveUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }
}
