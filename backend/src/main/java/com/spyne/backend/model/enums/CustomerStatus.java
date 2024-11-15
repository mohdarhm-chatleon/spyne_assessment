package com.spyne.backend.model.enums;

public enum CustomerStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    CustomerStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
