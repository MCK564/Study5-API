package com.mck.study5.learning_service.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data, int code, String message) {
        return new ApiResponse<>(200,true, message, data);
    }

    public static <T> ApiResponse<T> failure(T data, int code, String message) {
        return new ApiResponse<> (code,false, message, null);
    }


}
