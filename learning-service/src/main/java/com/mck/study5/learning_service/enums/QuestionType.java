package com.mck.study5.learning_service.enums;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum QuestionType {
    MULTIPLE_CHOICE("MULTIPLE_CHOICE"),
    SHORT_ANSWER("SHORT_ANSWER");

    private String type;
    QuestionType(String type){
        this.type = type;
    }
    public static QuestionType fromString(String type)
    {
        if(type == null)return null;
        return QuestionType.valueOf(type.toUpperCase());
    }

}
