package com.anbq.cuddlylamp.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String passwordEncoded;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private RoleEntity role;

}
