package com.mck.study5.payment_service.response;


import com.mck.study5.payment_service.constants.MessageKeys;
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
        return new ApiResponse<>(200,true, MessageKeys.SUCCESS, data);
    }

    public static <T> ApiResponse<T> failure(T data, int code, String message) {
        return new ApiResponse<> (code,false, message, null);
    }


}
