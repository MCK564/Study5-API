package com.mck.study5.user_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TodoListType {
    weekday, weekend, everyday;

    @JsonValue
    public String toString() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static TodoListType fromString(String value) {
        if(value == null) return null;
        return TodoListType.valueOf(value.toUpperCase());
    }
}
