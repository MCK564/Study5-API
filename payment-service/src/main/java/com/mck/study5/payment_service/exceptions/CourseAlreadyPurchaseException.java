package com.mck.study5.payment_service.exceptions;

public class CourseAlreadyPurchaseException extends RuntimeException {
    public CourseAlreadyPurchaseException(String message) {
        super(message);
    }
}
