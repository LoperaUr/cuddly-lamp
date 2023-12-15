package com.pragma.cuddlylamp.application.dto.req;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String role;

}
