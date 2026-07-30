package com.example.spring_rest_handson;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@RestController
public class AuthController {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/authenticate")
    public Map<String, String> authenticate(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        if ("admin".equals(username) && "password123".equals(password)) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 3600_000))
                    .signWith(key)
                    .compact();
            return Map.of("token", token);
        }
        return Map.of("error", "Invalid credentials");
    }
}