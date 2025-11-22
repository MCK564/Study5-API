package com.mck.study5.learning_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;


public enum QuestionStatus {
    DRAFT("DRAFT"),
    PUBLISHED("PUBLISHED"),
    ARCHIVED("ARCHIVED"),
    DELETED("DELETED");

    private String status;

    QuestionStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @JsonCreator
    public static QuestionStatus fromString(String status)
    {
        if(status == null)return null;
        return QuestionStatus.valueOf(status.toUpperCase());
    }

}
