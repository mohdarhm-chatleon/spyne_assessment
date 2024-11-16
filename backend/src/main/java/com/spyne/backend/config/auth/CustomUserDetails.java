package com.spyne.backend.config.auth;

import com.spyne.backend.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetails;

public interface CustomUserDetails  extends UserDetails {
    Role getRole();
}
