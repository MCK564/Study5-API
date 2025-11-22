package com.mck.study5.user_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TodoListType {
    WEEKDAY("WEEKDAY"),
    WEEKEND("WEEKEND"),
    EVERYDAY("EVERYDAY");


    private String type;
    TodoListType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonCreator
    public static TodoListType fromString(String value) {
        if(value == null) return null;
        return TodoListType.valueOf(value.toUpperCase());
    }
}
