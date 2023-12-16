package com.anbq.cuddlylamp.infrastructure.output.jpa.repository;

import com.anbq.cuddlylamp.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RolePersistencePortImpl implements IRolePersistencePort {

    private final IRoleRepository roleRepository;

    @Override
    public boolean existsById(Long id) {
        return roleRepository.existsById(id);
    }
}
