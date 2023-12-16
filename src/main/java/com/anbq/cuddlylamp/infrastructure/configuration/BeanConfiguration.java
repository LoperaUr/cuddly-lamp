package com.anbq.cuddlylamp.infrastructure.configuration;

import com.anbq.cuddlylamp.domain.spi.IRolePersistencePort;
import com.anbq.cuddlylamp.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.anbq.cuddlylamp.infrastructure.output.jpa.repository.IUserRepository;
import com.anbq.cuddlylamp.domain.api.IUserServicePort;
import com.anbq.cuddlylamp.domain.spi.IUserPersistencePort;
import com.anbq.cuddlylamp.domain.usecase.UserUseCase;
import com.anbq.cuddlylamp.infrastructure.output.jpa.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRolePersistencePort rolePersistencePort;


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), rolePersistencePort);
    }

}
