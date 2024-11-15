package com.spyne.backend.model.request.user;

import com.spyne.backend.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequest {

    private String email;
    private String password;
    private Role userRole;
}
