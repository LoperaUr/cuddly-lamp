package com.anbq.cuddlylamp.application.mapper;

import com.anbq.cuddlylamp.application.dto.res.UserResponse;
import com.anbq.cuddlylamp.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mapping(target = "role", source = "role.id")
    UserResponse toResponse(User user);

}
