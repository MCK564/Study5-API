package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.models.User;
import dtos.response.user.UserLoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    UserLoginResponse login();
    User findOrCreateUser(String email, String name, String provider);

}
