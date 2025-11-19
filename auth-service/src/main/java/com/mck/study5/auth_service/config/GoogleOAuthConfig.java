package com.mck.study5.auth_service.config;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.auth_service.props.FacebookProps;
import com.mck.study5.auth_service.props.GoogleProps;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Component
@Getter
public class GoogleOAuthConfig {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public GoogleProps googleProps() throws IOException{
        try(InputStream in = OAuthSecretsLoader.loadGoogleCredentials()){
            var root = objectMapper.readValue(in, GoogleSecretRoot.class);
            var web = Objects.requireNonNullElseGet(root.web, GoogleSecretWeb::new);

            String clientId = web.client_id;
            String clientSecret = web.client_secret;
            String authUri = web.auth_uri != null ? web.auth_uri : "https://accounts.google.com/o/oauth2/v2/auth";
            String tokenUri = web.token_uri != null ? web.token_uri : "https://oauth2.googleapis.com/token";
            String redirectUri = (web.redirect_uris != null && !web.redirect_uris.isEmpty())
                    ? web.redirect_uris.get(0)
                    : "http://localhost:8090/auth/oauth2/callback/google/google";

            return new GoogleProps(clientId, clientSecret, authUri, tokenUri, redirectUri);

        }
    }

    @Bean
    public FacebookProps facebookProps() throws IOException{
        try(InputStream in =  OAuthSecretsLoader.loadFacebookCredentials()){
            var root = objectMapper.readValue(in, FacebookSecret.class);

            String clientId = firstNonBlank(root.clientId, root.app_id);
            String clientSecret = firstNonBlank(root.clientSecret, root.app_secret);
            String tokenUri = "https://graph.facebook.com/v18.0/oauth/access_token";
            String redirectUri = firstNonBlank(root.redirectUri,
                    "http://localhost:8090/auth/oauth2/callback/facebook/facebook");
            return new FacebookProps(clientId, clientSecret, "https://www.facebook.com/v18.0/dialog/oauth", tokenUri, redirectUri);

        }

    }

    @Bean
    public RestClient oauthRestClient() {
        return RestClient.builder().build();
    }


    private static String firstNonBlank(String a, String b) {
        return (a != null && !a.isBlank()) ? a : b;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class GoogleSecretRoot {
        public GoogleSecretWeb web;
        public GoogleSecretWeb installed; // fallback nếu dùng kiểu "installed"
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class GoogleSecretWeb {
        public String client_id;
        public String project_id;
        public String auth_uri;
        public String token_uri;
        public String client_secret;
        public List<String> redirect_uris;
        public List<String> javascript_origins;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class FacebookSecret {
        // Hỗ trợ nhiều key đặt tên khác nhau
        public String clientId;
        public String clientSecret;
        public String app_id;
        public String app_secret;
        public String redirectUri;
    }

}
