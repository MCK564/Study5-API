package com.mck.study5.auth_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDTO {
    private String username;
    private String password;
    private String confirm_password;
    private String email;
    @JsonProperty("display_name")
    private String displayName;
}
