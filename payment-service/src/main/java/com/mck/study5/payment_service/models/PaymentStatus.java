package com.mck.study5.payment_service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {
    PENDING,
    FAILED,
    SUCCESS,
    EXPIRE;

    public  boolean isTerminated(){
        return this == FAILED || this == SUCCESS || this == EXPIRE;
    }

    @JsonValue
    public String toString(){
        return name().toLowerCase();
    }

    @JsonCreator
    public static PaymentStatus fromString(String value){
        if(value == null)return null;
        return PaymentStatus.valueOf(value.trim().toUpperCase());
    }
}
