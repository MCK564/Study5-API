package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.response.UserLoginResponse;
import org.springframework.stereotype.Service;


public interface IUserService {
    UserLoginResponse login(LoginRequestDTO dto);
    User findOrCreateUser(String email, String name, String provider);
    String createUser(RegisterRequestDTO dto);
}
