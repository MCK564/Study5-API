package com.mck.study5.auth_service.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.controllers.AuthController;
import com.mck.study5.auth_service.dto.LoginRequestDTO;
import com.mck.study5.auth_service.dto.RegisterRequestDTO;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.props.GoogleProps;
import com.mck.study5.auth_service.response.UserLoginResponse;
import com.mck.study5.auth_service.services.ExternalOAuthService;
import com.mck.study5.auth_service.services.IJwtService;
import com.mck.study5.auth_service.services.IUserService;
import com.mck.study5.auth_service.services.OAuthAuthorizeService;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        controllers = AuthController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GoogleProps googleProps;

    @MockBean
    private IUserService userService;

    @MockBean
    private IJwtService jwtService;

    @MockBean
    private OAuthAuthorizeService oAuthAuthorizeService;

    @MockBean
    private ExternalOAuthService externalOAuthService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void ping_shouldReturnPong() throws Exception {
        mockMvc.perform(get("/auth/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("pong"));
    }

    @Test
    void login_success() throws Exception {
        LoginRequestDTO loginRequestDTO = LoginRequestDTO.builder()
                .username("test")
                .password("123456")
                .build();

        UserLoginResponse loginResponse = UserLoginResponse.builder()
                .accessToken("accessToken")
                .refreshToken("refreshToken")
                .role("USER")
                .build();

        when(userService.login(any(LoginRequestDTO.class))).thenReturn(loginResponse);

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequestDTO))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.access_token").value("accessToken"))
                .andExpect(jsonPath("$.data.refresh_token").value("refreshToken"));
        verify(userService).login(any(LoginRequestDTO.class));
    }


    @Test
    void register_success() throws Exception {
        RegisterRequestDTO request = RegisterRequestDTO.builder()
                .username("test")
                .password("123456")
                .displayName("test")
                .email("test@gmail.com")
                .build();

        when(userService.createUser(any(RegisterRequestDTO.class))).thenReturn(MessageKeys.SUCCESS);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(MessageKeys.SUCCESS));
        verify(userService).createUser(any(RegisterRequestDTO.class));
    }



    @Test
    void googleUrl_shouldReturnGoogleUrl() throws Exception {
        String redirectAfter = "http://localhost:5173/after-login";
        String authUrl = "https://accounts.google.com/o/oauth2/v2/auth?xyz";

        when(oAuthAuthorizeService.buildGoogleAuthorizationUrl(redirectAfter))
                .thenReturn(authUrl);

        mockMvc.perform(get("/auth/oauth2/google/authorize")
                        .param("redirect_after", redirectAfter)) // ✅ trùng với @RequestParam
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(authUrl));

        verify(oAuthAuthorizeService).buildGoogleAuthorizationUrl(redirectAfter);
    }


    @Test
    void callbackGoogle_shouldReturnRedirectView() throws Exception {
        String code = "auth-code-123";
        String state = "xyz";

        UserLoginResponse loginResponse = UserLoginResponse.builder()
                .accessToken("access-token-from-google")
                .refreshToken("refresh-token-from-google")
                .build();

        when(externalOAuthService.exchangeGoogleCode(code))
                .thenReturn(loginResponse);

        mockMvc.perform(get("/auth/oauth2/callback/google")
                        .param("code", code)
                        .param("state", state))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("http://localhost:5173**"))
                .andExpect(result -> {
                    String url = result.getResponse().getRedirectedUrl();
                    Assertions.assertNotNull(url);
                    Assertions.assertTrue(url.contains("login=" + MessageKeys.SUCCESS));
                    Assertions.assertTrue(url.contains("access_token=" + loginResponse.getAccessToken()));
                    Assertions.assertTrue(url.contains("refresh_token=" + loginResponse.getRefreshToken()));
                });

        verify(externalOAuthService).exchangeGoogleCode(code);
    }

}

