package com.mathvieira.voll.med.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mathvieira.voll.med.entity.doctor.Doctor;

@Service
public class TokenService {
    @Value("${api.security.token.security}")
    private String secret;

    public String generateToken(Doctor doctor) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("voll.med")
                .withSubject(doctor.getEmail())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);

            return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            
            return JWT.require(algorithm)
                .withIssuer("voll.med")
                .build()
                .verify(token)
                .getSubject();
        } catch(JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
