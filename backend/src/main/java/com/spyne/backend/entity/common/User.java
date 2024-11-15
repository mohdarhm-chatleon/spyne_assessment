package com.spyne.backend.entity.common;

import com.spyne.backend.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import jakarta.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class User {

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "role", nullable = false, length = 50)
    private Role role;
}
