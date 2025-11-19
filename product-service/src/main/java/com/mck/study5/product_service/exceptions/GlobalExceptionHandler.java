package com.mck.study5.product_service.exceptions;



import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DataNotFoundException.class, EntityNotFoundException.class})
    public ApiResponse<String> handleDataNotFoundException(DataNotFoundException ex){
        return ApiResponse.failure(ex.getMessage(),404, MessageKeys.DATA_NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception ex){
        return ApiResponse.failure(ex.getMessage(),500, ex.getMessage());
    }

    @ExceptionHandler(InvalidDataException.class)
    public ApiResponse<String> handleInvalidDataException(InvalidDataException ex){
        return ApiResponse.failure(ex.getMessage(),400,MessageKeys.INVALID_REQUEST_DATA);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ApiResponse<String> handleTokenExpiredException(TokenExpiredException ex){
        return ApiResponse.failure(ex.getMessage(),401, MessageKeys.UNAUTHORIZED);
    }

    @ExceptionHandler(PermissionDenyException.class)
    public ApiResponse<String> handlePermissionDenyException(PermissionDenyException ex){
        return ApiResponse.failure(ex.getMessage(),403, MessageKeys.FORBIDDEN);
    }


    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ApiResponse<?>> handleMissingHeader(MissingRequestHeaderException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.failure(null, 401, MessageKeys.UNAUTHORIZED));
    }
}
