package com.mck.study5.auth_service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ROLE {
    ADMIN("ADMIN"),
    STAFF("STAFF"),
    USER("USER");


    private String role;
    ROLE(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @JsonValue
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static ROLE fromString(String value) {
        if(value == null) return null;
        return ROLE.valueOf(value.toUpperCase());
    }
}
