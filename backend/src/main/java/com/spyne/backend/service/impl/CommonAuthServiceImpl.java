package com.spyne.backend.service.impl;

import com.spyne.backend.model.request.user.UserSignInRequest;
import com.spyne.backend.model.response.user.LoginResponse;
import com.spyne.backend.service.contract.CommonAuthService;
import org.springframework.stereotype.Service;

@Service
public class CommonAuthServiceImpl implements CommonAuthService {

    @Override
    public LoginResponse loginUser(UserSignInRequest request) {
        return null;
    }
}
