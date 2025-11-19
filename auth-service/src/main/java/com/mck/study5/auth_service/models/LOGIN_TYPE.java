package com.mck.study5.auth_service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



public enum LOGIN_TYPE {
    GOOGLE("GOOGLE"),
    FACEBOOK("FACEBOOK"),
    LOCAL("LOCAL");

    private String type;

    LOGIN_TYPE(String type){
        this.type = type;
    }

    @JsonValue
    public String toString() {
        return name().toLowerCase();
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        setType(type);
    }

    @JsonCreator
    public static LOGIN_TYPE fromString(String value) {
        if(value == null) return null;
        return LOGIN_TYPE.valueOf(value.toUpperCase());
    }

}
