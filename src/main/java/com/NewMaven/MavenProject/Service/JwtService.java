package com.NewMaven.MavenProject.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    // 32+ character secret key (HS256)
    private final String secret = "mysecretkey123456mysecretkey123456";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 86400000)) // valid for 24 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
