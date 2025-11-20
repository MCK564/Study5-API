package com.mck.study5.learning_service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum ExamStatus {
    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private String status;
    ExamStatus(String status){
        this.status = status;
    }

    @JsonCreator
    public static ExamStatus fromString(String status)
    {
        if(status == null)return null;
        return ExamStatus.valueOf(status.toUpperCase());
    }
}
