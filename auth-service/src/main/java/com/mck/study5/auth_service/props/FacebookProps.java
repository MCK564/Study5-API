package com.mck.study5.auth_service.props;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FacebookProps {
    private final String clientId;
    private final String clientSecret;
    private final String authUri;
    private final String tokenUri;
    private final String redirectUri;

    public FacebookProps(String clientId, String clientSecret, String authUri, String tokenUri, String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.authUri = authUri;
        this.tokenUri = tokenUri;
        this.redirectUri = redirectUri;
    }

}
