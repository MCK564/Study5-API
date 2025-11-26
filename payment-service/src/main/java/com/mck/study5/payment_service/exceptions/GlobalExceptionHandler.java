package com.mck.study5.payment_service.exceptions;


import com.mck.study5.payment_service.constants.MessageKeys;
import com.mck.study5.payment_service.response.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler({CourseAlreadyPurchaseException.class, EntityNotFoundException.class})
    public ApiResponse<String> handleDataNotFoundException(CourseAlreadyPurchaseException ex){
        return ApiResponse.failure(ex.getMessage(),400, MessageKeys.COURSE_ALREADY_PURCHASED_BY_THIS_USER);
    }
}
