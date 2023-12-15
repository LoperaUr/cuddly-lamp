package com.pragma.cuddlylamp.application.mapper;

import com.pragma.cuddlylamp.application.dto.res.UserResponse;
import com.pragma.cuddlylamp.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mapping(target = "role", source = "role.id")
    UserResponse toResponse(User user);

}
