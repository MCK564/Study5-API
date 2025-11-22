package com.mck.study5.learning_service.enums;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum ExamStatus {
    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private String status;
    ExamStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @JsonCreator
    public static ExamStatus fromString(String status)
    {
        if(status == null)return null;
        return ExamStatus.valueOf(status.toUpperCase());
    }
}
