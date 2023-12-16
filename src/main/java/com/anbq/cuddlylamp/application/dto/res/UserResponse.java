package com.anbq.cuddlylamp.application.dto.res;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private Long role;

}
