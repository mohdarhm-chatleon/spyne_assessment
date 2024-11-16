package com.spyne.backend.config.auth;

import com.spyne.backend.model.enums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${jwt.audience}")
    private String audience;

    public Role getRoleFromToken(Claims claims){
        try {
            String roleName = claims.get("role", String.class);
            if (roleName != null) {
                return Role.valueOf(roleName);
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role in token", e);
        }
        throw new RuntimeException("Role not found in token");
    }

    public Boolean validateClaims(Claims claims){
        return claims.getExpiration().after(new Date()) && claims.getAudience().contains(audience);
    }

    public Claims verifySignatureAndGetAllClaims(String token){
        Jwt<?, ?> jwt = Jwts.parser()
                .build()
                .parseSignedClaims(token);

        return (Claims) jwt.getPayload();
    }
}
