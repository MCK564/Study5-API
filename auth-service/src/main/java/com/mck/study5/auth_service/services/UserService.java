package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.models.User;
import dtos.response.user.UserLoginResponse;

public class UserService implements IUserService {
    @Override
    public UserLoginResponse login() {
        return null;
    }

    @Override
    public User findOrCreateUser(String email, String name, String provider) {
        return null;
    }
}
