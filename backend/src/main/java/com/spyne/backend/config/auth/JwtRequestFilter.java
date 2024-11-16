package com.spyne.backend.config.auth;

import com.spyne.backend.model.enums.Role;

import io.jsonwebtoken.Claims;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Some logic will go here. right now everyone passes the security challenge and are admins
        final String tokenFromRequest = request.getHeader("Authorization");

        String email = null;
        Role role = null;
        boolean isValidToken = false;

        if (Objects.nonNull(tokenFromRequest) && tokenFromRequest.startsWith("Bearer ")) {
            String jwtToken = tokenFromRequest.substring(7);

            Claims claims = jwtTokenUtil.verifySignatureAndGetAllClaims(jwtToken);
            isValidToken = jwtTokenUtil.validateClaims(claims);
            role = jwtTokenUtil.getRoleFromToken(claims);

            email = (String) claims.get("email");

        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                "defaultUser",
                null,
                List.of(Role.ADMIN)
        );
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }
}
