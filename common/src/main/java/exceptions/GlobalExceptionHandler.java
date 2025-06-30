package exceptions;

import constants.MessageKeys;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
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
}
