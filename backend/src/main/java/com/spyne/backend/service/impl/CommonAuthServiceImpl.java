package com.spyne.backend.service.impl;

import com.spyne.backend.entity.EmailHashMapping;
import com.spyne.backend.exception.BadRequestException;
import com.spyne.backend.exception.BaseException;
import com.spyne.backend.exception.InternalServerException;
import com.spyne.backend.model.request.user.UserSignInRequest;
import com.spyne.backend.model.request.user.UserSignUpRequest;
import com.spyne.backend.model.response.user.AuthAndAccessTokens;
import com.spyne.backend.model.response.user.LoginResponse;
import com.spyne.backend.repo.EmailHashMappingRepo;
import com.spyne.backend.service.contract.CommonAuthService;
import com.spyne.backend.util.PasswordUtils;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Service
public class CommonAuthServiceImpl implements CommonAuthService {

    @Autowired
    EmailHashMappingRepo emailHashMappingRepo;

    @Value("${jwt.secret}")
    private String signingSecret;

    @Value("${jwt.expiration}")
    private int expiry;

    @Value("${jwt.audience}")
    private String audience;

    @Override
    public LoginResponse loginUser(UserSignInRequest request) throws BaseException {

        /*
         * The simplest form of auth -- password hashing and comparison.
         */

        LoginResponse response = new LoginResponse();
        String encodedHash = PasswordUtils.hashPassword(request.getPassword());

        EmailHashMapping emailHashMappingForCurrentUser = emailHashMappingRepo.findByEmailAndHashAndRole(request.getEmail(), encodedHash, request.getUserRole());
        if (Objects.isNull(emailHashMappingForCurrentUser)){
            throw new BadRequestException(HttpStatus.BAD_REQUEST.value(), "Invalid Credentials");
        } else {
            // Password matches -> generate tokens

            long expirationMillis = expiry * 1000L;
            Date now = new Date();
            Date expiration = new Date(now.getTime() + expirationMillis);

            String jwtToken = Jwts.builder()
                    .setAudience(audience) // This can be checked at the time of parsing, that the json is signed by us.
                    .setSubject(request.getEmail())
                    .setIssuer("spyne-sample-app")
                    .setIssuedAt(now)
                    .claim("user_role", request.getUserRole()) // should verify first that such a user with the claimed role exists or not
                    .setExpiration(expiration)
                    .signWith(Keys.hmacShaKeyFor(signingSecret.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                    .compact();
            // In a real app, use an external service for this such as aws cognito

            AuthAndAccessTokens tokens = new AuthAndAccessTokens();
            tokens.setAuth(jwtToken);
            tokens.setAccess("this is just an example, ideally the access token guarantees the scope of a user");

            response.setTokens(tokens);
            response.setMessage("Logged in successfully!");
            return response;
        }
    }

    @Override
    public LoginResponse signUpUser(UserSignUpRequest request) {
        return null;
    }
}
