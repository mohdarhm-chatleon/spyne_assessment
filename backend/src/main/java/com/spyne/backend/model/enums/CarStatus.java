package com.spyne.backend.model.enums;

public enum CarStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    CarStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
