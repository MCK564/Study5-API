package com.mck.study5.auth_service.dto;

import lombok.*;

@Data
public class RegisterRequestDTO {
    private String username;
    private String password;
    private String confirm_password;
}
