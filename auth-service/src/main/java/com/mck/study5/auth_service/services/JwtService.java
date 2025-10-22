package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.models.User;

public class JwtService implements IJwtService{
    @Override
    public String generateToken(User user) {
        return "";
    }

    @Override
    public String generateRefreshToken(User user) {
        return "";
    }

    @Override
    public Boolean isExpired(String accessToken) {
        return null;
    }

    @Override
    public String getNewAccessToken(String refreshToken) {
        return "";
    }

    @Override
    public String extractEmail(String token) {
        return null;
    }

}
