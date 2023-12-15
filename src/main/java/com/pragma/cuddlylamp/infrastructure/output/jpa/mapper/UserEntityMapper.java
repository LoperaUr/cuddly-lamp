package com.pragma.cuddlylamp.infrastructure.output.jpa.mapper;

import com.pragma.cuddlylamp.domain.model.User;
import com.pragma.cuddlylamp.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);

}
