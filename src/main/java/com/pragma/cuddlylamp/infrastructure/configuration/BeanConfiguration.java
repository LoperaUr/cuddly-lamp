package com.pragma.cuddlylamp.infrastructure.configuration;

import com.pragma.cuddlylamp.domain.api.IUserServicePort;
import com.pragma.cuddlylamp.domain.spi.IUserPersistencePort;
import com.pragma.cuddlylamp.domain.usecase.UserUseCase;
import com.pragma.cuddlylamp.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.cuddlylamp.infrastructure.output.jpa.mapper.UserEntityMapper;
import com.pragma.cuddlylamp.infrastructure.output.jpa.repository.IUserRepository;
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

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IUserPersistencePort userPersistencePort () {
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort () {
        return new UserUseCase(userPersistencePort());
    }

}
