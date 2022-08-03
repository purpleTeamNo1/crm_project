package com.example.backend.utils;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class TokenUtils {
    static final int TIME = 1000 * 60 * 60 * 24;
    static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String createToken(String username, String role){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //Header
                .setHeaderParam("type", "JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username",username)
                .claim("role",role)
                .setSubject("token-generation")
                .setExpiration(new Date(System.currentTimeMillis() + TIME))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(key)
                .compact();
        return jwtToken;
    }

}
