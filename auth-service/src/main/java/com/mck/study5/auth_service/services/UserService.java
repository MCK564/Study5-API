package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.exceptions.InvalidDataException;
import com.mck.study5.auth_service.models.ROLE;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.repositories.UserRepository;
import com.mck.study5.auth_service.response.UserLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IJwtService jwtService;
    private final UserRepository userRepository;


    @Override
    public UserLoginResponse login(LoginRequestDTO dto) {
       User existedUser = userRepository.findByEmail(dto.getEmail())
               .orElseThrow(()-> new InvalidDataException(MessageKeys.INVALID_REQUEST_DATA));

       if(!existedUser.getPassword().equals(dto.getPassword())){
           return UserLoginResponse.builder()
                   .message(MessageKeys.WRONG_PASSWORD)
                   .build();
       }
       String accessToken = jwtService.generateToken(existedUser);
       String refreshToken = jwtService.generateRefreshToken(existedUser);

        return UserLoginResponse.builder()
                .message(MessageKeys.LOGIN_SUCCESS)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public User findOrCreateUser(String email, String name, String provider) {
        return null;
    }

    @Override
    public String createUser(RegisterRequestDTO dto) {
        if(userRepository.existsByEmailOrUsername(dto.getUsername(), dto.getUsername()))
            return MessageKeys.USER_ALREADY_EXISTS;
        if(!dto.getConfirm_password().equals(dto.getPassword()))
            return MessageKeys.WRONG_PASSWORD;

        User newUser = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(ROLE.USER.getRole())
                .build();

        userRepository.save(newUser);
        return MessageKeys.SUCCESS;
    }


}
