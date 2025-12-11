package com.mck.study5.auth_service.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.props.GoogleProps;
import com.mck.study5.auth_service.repositories.UserRepository;
import com.mck.study5.auth_service.services.ExternalOAuthService;
import com.mck.study5.auth_service.services.OAuthAuthorizeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {

                "GOOGLE_OAUTH_CREDENTIALS_BASE64=dGVzdA=="
        }
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private OAuthAuthorizeService oAuthAuthorizeService;

    @MockBean
    private ExternalOAuthService externalOAuthService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @MockBean
    private GoogleProps googleProps;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void register_shouldPersistUserInDatabase() throws Exception{
        RegisterRequestDTO request = RegisterRequestDTO.builder()
                .username("it_user")
                .password("123456")
                .confirm_password("123456")
                .displayName("Integration User")
                .email("it_user@gmail.com")
                .build();

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content((objectMapper.writeValueAsString(request))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(MessageKeys.SUCCESS));

        assertThat(userRepository.findByEmail("it_user@gmail.com")).isPresent();
    }

    @Test
    void login_shouldReturnTokensForExistingUser() throws Exception{
        String rawPassword = "123456";

        User user = User.builder()
                .username("login_user")
                .email("login_user@gmail.com")
                .password(passwordEncoder.encode(rawPassword))
                .build();

        userRepository.save(user);

        LoginRequestDTO dto = LoginRequestDTO.builder()
                .username("login_user")
                .password(rawPassword)
                .build();

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.access_token").isNotEmpty())
                .andExpect(jsonPath("$.data.refresh_token").isNotEmpty());
    }

}
