package com.mck.study5.auth_service.service;


import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.exceptions.InvalidDataException;
import com.mck.study5.auth_service.models.LOGIN_TYPE;
import com.mck.study5.auth_service.models.ROLE;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.repositories.UserRepository;
import com.mck.study5.auth_service.response.UserLoginResponse;
import com.mck.study5.auth_service.services.IJwtService;
import com.mck.study5.auth_service.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private IJwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void login_shouldReturnLoginResponse(){
        LoginRequestDTO dto  = LoginRequestDTO.builder()
                .username("test")
                .password("123456")
                .build();

        User user = User.builder()
                .username("test")
                .password("encoded-password")
                .role(ROLE.USER.getRole())
                .build();

        when(userRepository.findByUsername("test")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("123456", "encoded-password")).thenReturn(true);
        when(jwtService.generateToken(user)).thenReturn("accessToken");
        when(jwtService.generateRefreshToken(user)).thenReturn("refreshToken");


        UserLoginResponse response = userService.login(dto);

        assertThat(response.getAccessToken()).isEqualTo("accessToken");
        assertThat(response.getRefreshToken()).isEqualTo("refreshToken");
        assertThat(response.getRole()).isEqualTo(ROLE.USER.getRole());

        verify(userRepository).findByUsername("test");
        verify(passwordEncoder).matches("123456","encoded-password");
        verify(jwtService).generateToken(user);
        verify(jwtService).generateRefreshToken(user);
    }


    @Test
    void register_shouldCreateUserAndReturnSuccessMessage(){

        RegisterRequestDTO dto = RegisterRequestDTO.builder()
                .username("test")
                .password("123456")
                .confirm_password("123456")
                .email("test@gmail.com")
                .displayName("test")
                .build();

        when(passwordEncoder.encode("123456")).thenReturn("encoded-password");
        when(userRepository.save(ArgumentMatchers.any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        String result = userService.createUser(dto);

        assertThat(result).isEqualTo(MessageKeys.SUCCESS);
        verify(passwordEncoder).encode("123456");
        verify(userRepository).save(ArgumentMatchers.any(User.class));
    }

}
