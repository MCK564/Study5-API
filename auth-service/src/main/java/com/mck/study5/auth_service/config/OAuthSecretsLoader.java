package com.mck.study5.auth_service.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public final class OAuthSecretsLoader {
    private OAuthSecretsLoader() {
    }

    public static InputStream loadGoogleCredentials() throws IOException {
        return loadFromEnvOrFile(
                "GOOGLE_OAUTH_CREDENTIALS_BASE64",
                "GOOGLE_OAUTH_CREDENTIALS_PATH"
        );
    }

    public static InputStream loadFacebookCredentials() throws IOException {
        return loadFromEnvOrFile(
                "FACEBOOK_OAUTH_CREDENTIALS_BASE64",
                "FACEBOOK_OAUTH_CREDENTIALS_PATH"
        );
    }
    private static InputStream loadFromEnvOrFile(String base64Env, String pathEnv) throws IOException {
        String base64 = System.getenv(base64Env);
        if (base64 != null && !base64.isBlank()) {
            byte[] decoded = Base64.getDecoder().decode(base64);
            return new ByteArrayInputStream(decoded);
        }
        String path = System.getenv(pathEnv);
        if (path != null && !path.isBlank()) {
            return Files.newInputStream(Path.of(path));
        }
        throw new IOException("Missing secrets. Set either " + base64Env + " or " + pathEnv + ".");
    }

}
