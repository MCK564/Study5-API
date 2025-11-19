package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.models.User;
import org.springframework.stereotype.Service;


public interface IJwtService {
    public String generateToken(User user);
    public String generateRefreshToken(User user);
    public Boolean isExpired(String accessToken);
    public String getNewAccessToken(String refreshToken);
    public String extractEmail(String token);
    String generateShortLivedStateToken(String google, String redirectUri);
}
