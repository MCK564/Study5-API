package com.mck.study5.product_service.constants;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class MessageKeys {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILURE = "FAILURE";
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOGIN_FAILURE = "LOGIN_FAILURE";
    public static final String TOKEN_EXPIRED = "TOKEN_EXPIRED";
    public static final String TOKEN_INVALID = "TOKEN_INVALID";
    public static final String EXAM_TIME_OUT = "EXAM_TIME_OUT";
    public static final String USER_IS_LOCKED = "user_is_locked";
    public static final String DELETE_SUCCESSFULLY = "delete successfully";
    public static final String UPLOAD_IMAGES_MAX_5 = "product.upload_images.error_max_5_images";
    public static final String UPLOAD_IMAGES_FILE_LARGE = "product.upload_images.file_large";
    public static final String UPLOAD_IMAGES_FILE_MUST_BE_IMAGE = "product.upload_images.file_must_be_image";
    public static final String EMPTY_REQUEST = "empty request";
    public static final String DATA_NOT_FOUND = "DATA_NOT_FOUND";
    public static final String MAIL_SENT_SUCCESSFULLY = "sent_mail_successfully";
    public static final String INVALID_REQUEST_DATA = "INVALID_REQUEST_DATA";
    public static final String UNAUTHORIZED = "UNAUTHORIZED";
    public static final String FORBIDDEN = "FORBIDDEN";
    public static final String NULL_REQUEST_DTO ="NULL_REQUEST_DTO";
    public static final String SUBJECT_NOT_FOUND = "SUBJECT_NOT_FOUND";
    public static final String INVALID_JWT_SIGNATURE = "INVALID_JWT_SIGNATURE";
    public static final String SERVICE_UNAVAILABLE = "Service temporarily unavailable. Please try again later";
    public static final String COURSE_INVALID = "course_invalid";
}
