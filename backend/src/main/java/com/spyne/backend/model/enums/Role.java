package com.spyne.backend.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("admin"),
    DEALER("dealer"),
    COMPANY("company"),
    CUSTOMER("customer");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String getAuthority() {
        return value;
    }
}
