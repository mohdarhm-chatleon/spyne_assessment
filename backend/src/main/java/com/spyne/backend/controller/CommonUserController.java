package com.spyne.backend.controller;

import com.spyne.backend.exception.BaseException;
import com.spyne.backend.model.request.user.UserSignInRequest;
import com.spyne.backend.model.request.user.UserSignUpRequest;
import com.spyne.backend.model.response.user.LoginResponse;
import com.spyne.backend.service.contract.CommonAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Onboarding", description = "APIs to Register,login and other account related operations, common to all types of users.")
public class CommonUserController {

    @Autowired
    private CommonAuthService commonAuthService;

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Login")
    public LoginResponse login(@RequestBody @Valid UserSignInRequest loginRequest) throws BaseException {
        return commonAuthService.loginUser(loginRequest);
    }

    @PostMapping(
            value = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a user account")
    public LoginResponse signUp(@RequestBody @Valid UserSignUpRequest signUpRequest) throws BaseException {
        return commonAuthService.signUpUser(signUpRequest);
    }
}
