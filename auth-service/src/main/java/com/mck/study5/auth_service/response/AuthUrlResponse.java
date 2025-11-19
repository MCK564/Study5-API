package com.mck.study5.auth_service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUrlResponse {
    private String provider;
    private String authorizationUrl;
    private String state;
}
