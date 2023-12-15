package com.pragma.cuddlylamp.application.mapper;

import com.pragma.cuddlylamp.application.dto.req.UserRequest;
import com.pragma.cuddlylamp.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    @Mapping(target = "role.id", source = "role")
    User toModel(UserRequest userRequest);

}
