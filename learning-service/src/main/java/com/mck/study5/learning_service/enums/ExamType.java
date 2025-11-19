package com.mck.study5.learning_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum ExamType {
    LISTENING("LISTENING"),
    READING("READING"),
    WRITING("WRITING"),
    SPEAKING("SPEAKING");

    private String type;

    ExamType(String type){
        this.type = type;
    }


    @JsonCreator
    public static ExamType fromString(String type)
    {
        if(type == null)return null;
        return ExamType.valueOf(type.toUpperCase());
    }
}
