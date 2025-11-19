package com.mck.study5.auth_service.services;

import com.mck.study5.auth_service.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JwtService implements IJwtService {

    @Value("${jwt.secretKey}")
    private String secretKey;


    @Value("${jwt.accessTtlSeconds:900}")
    private long accessTtlSeconds;

    @Value("${jwt.refreshTtlSeconds:2592000}")
    private long refreshTtlSeconds;

    @Value("${jwt.stateTtlSeconds:300}")
    private long stateTtlSeconds;


    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }


    private String buildToken(String subject, long ttlSeconds, Map<String, Object> extraClaims) {
        Instant now = Instant.now();
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(ttlSeconds)))
                .subject(subject)
                .claims(extraClaims == null ? Map.of() : extraClaims)
                .signWith(getKey())
                .compact();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    @Override
    public String generateToken(User user) {
        // subject là email (hoặc userId tùy hệ thống)
        String subject = user.getEmail() != null ? user.getEmail() : String.valueOf(user.getId());
        return buildToken(subject, accessTtlSeconds, Map.of(
                "typ", "access",
                "id", user.getId(),
                "role", user.getRole() != null ? user.getRole() : "USER"
        ));
    }

    @Override
    public String generateRefreshToken(User user) {
        String subject = user != null
                ? (user.getEmail() != null ? user.getEmail() : String.valueOf(user.getId()))
                : "anonymous";
        return buildToken(subject, refreshTtlSeconds, Map.of(
                "typ", "refresh",
                "id", user != null ? user.getId() : null
        ));
    }

    @Override
    public Boolean isExpired(String accessToken) {
        try {
            Date exp = parseClaims(accessToken).getExpiration();
            return exp.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public String getNewAccessToken(String refreshToken) {
        Claims claims = parseClaims(refreshToken);
        if (!"refresh".equals(claims.get("typ"))) {
            throw new IllegalArgumentException("Invalid token type: not a refresh token");
        }
        String subject = claims.getSubject(); // email hoặc userId
        Long uid = claims.get("uid", Long.class);


        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plusSeconds(accessTtlSeconds)))
                .subject(subject)
                .claim("typ", "access")
                .claim("uid", uid)
                .signWith(getKey())
                .compact();
    }

    @Override
    public String extractEmail(String token) {
        try {
            return parseClaims(token).getSubject();
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public String generateShortLivedStateToken(String provider, String redirectAfterLogin) {
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(stateTtlSeconds);

        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(Date.from(now))
                .expiration(Date.from(exp))
                .subject(provider)
                .claim("redir", redirectAfterLogin)
                .claim("nonce", UUID.randomUUID().toString())
                .signWith(getKey(), Jwts.SIG.HS256)
                .compact();
    }
}
