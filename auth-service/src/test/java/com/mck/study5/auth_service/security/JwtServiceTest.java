package com.mck.study5.auth_service.security;

import com.mck.study5.auth_service.models.User;
import com.mck.study5.auth_service.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
public class JwtServiceTest {
    private JwtService jwtService;

//    fake secretKey
    private static final String TEST_SECRET =
            "01234567890123456789012345678901";

    private SecretKey key;

    @BeforeEach
    void setUp(){
        jwtService = new JwtService();

        ReflectionTestUtils.setField(jwtService, "secretKey", TEST_SECRET);
        ReflectionTestUtils.setField(jwtService, "accessTtlSeconds", 900L);
        ReflectionTestUtils.setField(jwtService, "refreshTtlSeconds", 86400L);
        ReflectionTestUtils.setField(jwtService, "stateTtlSeconds",300L);

        key = Keys.hmacShaKeyFor(TEST_SECRET.getBytes(StandardCharsets.UTF_8));
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    @Test
    void generateToken_shouldReturnToken(){
        User user = User.builder()
                .id(1L)
                .email("test@gmail.com")
                .role("USER")
                .build();

        String token = jwtService.generateToken(user);

        Claims claims  = parseClaims(token);

        assertThat(claims.getSubject()).isEqualTo(user.getEmail());
        assertThat(claims.get("typ", String.class)).isEqualTo("access");
        assertThat(claims.get("id", Number.class).longValue()).isEqualTo(1L);
        assertThat(claims.get("role", String.class)).isEqualTo("USER");

        assertTrue(claims.getExpiration().after(new Date()));
    }

    @Test
    void generateRefreshToken_shouldContainRefreshType(){
        User user = User.builder()
                .id(2L)
                .email("refresh@gmail.com")
                .build();


        String token = jwtService.generateRefreshToken(user);

        Claims claims = parseClaims(token);


        assertThat(claims.getSubject()).isEqualTo("refresh@gmail.com");
        assertThat(claims.get("typ", String.class)).isEqualTo("refresh");
        assertThat(claims.get("id",Number.class).longValue()).isEqualTo(2L);


    }

    @Test
    void isExpired_shouldReturnFalseForFreshAccessToken() {
        User user = User.builder()
                .id(1L)
                .email("test@example.com")
                .build();

        String token = jwtService.generateToken(user);

        Boolean expired = jwtService.isExpired(token);

        assertFalse(expired);
    }

    @Test
    void isExpired_shouldReturnTrueForExpiredAccessToken() {
        // set TTL âm để token hết hạn ngay lập tức
        ReflectionTestUtils.setField(jwtService, "accessTtlSeconds", -60L);

        User user = User.builder()
                .id(1L)
                .email("expired@example.com")
                .build();

        String token = jwtService.generateToken(user);

        Boolean expired = jwtService.isExpired(token);

        assertTrue(expired);
    }

    @Test
    void extractEmail_shouldReturnSubject() {
        User user = User.builder()
                .id(1L)
                .email("extract@example.com")
                .build();

        String token = jwtService.generateToken(user);

        String email = jwtService.extractEmail(token);

        assertThat(email).isEqualTo("extract@example.com");
    }

    @Test
    void extractEmail_shouldReturnNullForInvalidToken() {
        String bogus = "not-a-jwt-token";

        String email = jwtService.extractEmail(bogus);
        assertNull(email);
    }

    @Test
    void getNewAccessToken_shouldCreateAccessTokenFromRefreshToken() {
        // ở đây em tự build refresh token đúng format mà getNewAccessToken mong đợi:
        // typ = "refresh" và claim "uid"
        Instant now = Instant.now();
        String refreshToken = Jwts.builder()
                .id("refresh-id")
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(3600)))
                .subject("user@example.com")
                .claim("typ", "refresh")
                .claim("uid", 123L)
                .signWith(key)
                .compact();

        String newAccessToken = jwtService.getNewAccessToken(refreshToken);

        Claims claims = parseClaims(newAccessToken);

        assertThat(claims.get("typ", String.class)).isEqualTo("access");
        assertThat(claims.get("uid", Number.class).longValue()).isEqualTo(123L);
        assertThat(claims.getSubject()).isEqualTo("user@example.com");
        assertTrue(claims.getExpiration().after(new Date()));
    }

    @Test
    void generateShortLivedStateToken_shouldContainProviderAndRedirect() {
        String provider = "google";
        String redirect = "http://localhost:5173/after-login";

        String stateToken = jwtService.generateShortLivedStateToken(provider, redirect);

        Claims claims = parseClaims(stateToken);

        assertThat(claims.getSubject()).isEqualTo(provider);
        assertThat(claims.get("redir", String.class)).isEqualTo(redirect);
        assertThat(claims.get("nonce", String.class)).isNotBlank();
        assertTrue(claims.getExpiration().after(new Date()));
    }

}
