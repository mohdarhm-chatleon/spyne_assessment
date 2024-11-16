package com.spyne.backend.service.contract;

import com.spyne.backend.exception.BaseException;
import com.spyne.backend.model.request.user.UserSignInRequest;
import com.spyne.backend.model.request.user.UserSignUpRequest;
import com.spyne.backend.model.response.user.LoginResponse;

public interface CommonAuthService {

    public LoginResponse loginUser(UserSignInRequest request) throws BaseException;

    public LoginResponse signUpUser(UserSignUpRequest request);
}
