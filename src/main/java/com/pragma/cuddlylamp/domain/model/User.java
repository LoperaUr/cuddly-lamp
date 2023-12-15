package com.pragma.cuddlylamp.domain.model;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String passwordEncoded;
    private Role role;

}
