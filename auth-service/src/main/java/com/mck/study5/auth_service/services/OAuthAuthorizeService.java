package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.props.GoogleProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class OAuthAuthorizeService {
    private final GoogleProps googleProps;
    private final IJwtService jwtService;

    public String buildGoogleAuthorizationUrl(String overrideRedirect){
        String redirectUri = (overrideRedirect != null && !overrideRedirect.isBlank())
                ? overrideRedirect
                : googleProps.getRedirectUri();

        // state ngắn hạn, ký bằng HMAC
        String state = jwtService.generateShortLivedStateToken("google", redirectUri);

        // Google chấp nhận scope cách nhau bằng space, ta để nguyên và để builder encode
        String scope = "openid email profile";

        return UriComponentsBuilder
                .fromHttpUrl(googleProps.getAuthUri())
                .queryParam("client_id", googleProps.getClientId())
                .queryParam("redirect_uri", redirectUri)
                .queryParam("response_type", "code")
                .queryParam("scope", scope)
                .queryParam("access_type", "offline")
                .queryParam("prompt", "consent")
                .queryParam("state", state)
                // ✨ QUAN TRỌNG: encode trước khi build
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUriString();
    }

    // nếu vẫn cần “state-only” cho response
    public String issueStateOnly() {
        return jwtService.generateShortLivedStateToken("google", null);
    }
}

