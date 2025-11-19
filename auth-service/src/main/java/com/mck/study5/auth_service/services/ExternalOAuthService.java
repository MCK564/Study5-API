package com.mck.study5.auth_service.services;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.auth_service.constants.MessageKeys;
import com.mck.study5.auth_service.kafka.UserEventPublisher;
import com.mck.study5.auth_service.kafka.events.UserInfoCreateEvent;
import com.mck.study5.auth_service.models.LOGIN_TYPE;
import com.mck.study5.auth_service.models.ROLE;
import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.props.FacebookProps;
import com.mck.study5.auth_service.props.GoogleProps;
import com.mck.study5.auth_service.repositories.UserRepository;
import com.mck.study5.auth_service.response.UserLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExternalOAuthService {
    private final ObjectMapper objectMapper;
    private final GoogleProps googleProps;
    private final FacebookProps facebookProps;
    private final WebClient webClient = WebClient.builder().build();
    private final RestClient oauthRestClient;
    private final UserRepository userRepository;
    private final IJwtService jwtService;
    private final UserEventPublisher userEventPublisher ;

    public UserLoginResponse exchangeGoogleCode(String code) {

        var tokenResp = webClient.post()
                .uri(googleProps.getTokenUri()) // https://oauth2.googleapis.com/token
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("code", code)
                        .with("client_id", googleProps.getClientId())
                        .with("client_secret", googleProps.getClientSecret())
                        .with("redirect_uri", googleProps.getRedirectUri())
                        .with("grant_type", "authorization_code"))
                .retrieve()
                .bodyToMono(GoogleTokenResponse.class)
                .block();

        var userInfo = webClient.get()
                .uri("https://openidconnect.googleapis.com/v1/userinfo")
                .headers(h -> h.setBearerAuth(Objects.requireNonNull(tokenResp).access_token()))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        User existedUser = null;
        if(userInfo != null){
            existedUser = userRepository.findByEmail(userInfo.get("email").toString()).orElse(null);
            if(existedUser == null){
                User newUser = User.builder()
                        .email(userInfo.get("email").toString())
                        .displayName(userInfo.get("name").toString())
                        .role(ROLE.USER.getRole())
                        .loginType(LOGIN_TYPE.GOOGLE.getType())
                        .build();
                 existedUser = userRepository.save(newUser);

                UserInfoCreateEvent event = UserInfoCreateEvent.builder()
                        .sub(userInfo.get("sub").toString())
                        .name(userInfo.get("name").toString())
                        .email(userInfo.get("email").toString())
                        .picture(userInfo.get("picture").toString())
                        .id(existedUser.getId())
                        .build();

                userEventPublisher.publishUserCreated(event);

            }
        }
        
        String accessToken = jwtService.generateToken(existedUser);
        String refreshToken = jwtService.generateRefreshToken(existedUser);
        
        return UserLoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .message(MessageKeys.LOGIN_SUCCESS)
                .build();
    }


    public Map<String, Object> exchangeFacebookCode(String code) {
        var tokenResp = oauthRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(facebookProps.getTokenUri())
                        .queryParam("client_id", facebookProps.getClientId())
                        .queryParam("redirect_uri", facebookProps.getRedirectUri())
                        .queryParam("client_secret", facebookProps.getClientSecret())
                        .queryParam("code", code)
                        .build()
                )
                .retrieve()
                .body(FacebookTokenResponse.class);

        var userInfo = oauthRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("https://graph.facebook.com/me")
                        .queryParam("fields", "id,name,email,picture")
                        .queryParam("access_token", tokenResp.access_token)
                        .build()
                )
                .retrieve()
                .body(Map.class);
        return userInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record GoogleTokenResponse(String access_token, String id_token, String refresh_token, String token_type, Long expires_in) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record FacebookTokenResponse(String access_token, String token_type, Long expires_in) {}

}
