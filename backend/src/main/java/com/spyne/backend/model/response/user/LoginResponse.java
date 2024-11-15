package com.spyne.backend.model.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spyne.backend.model.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class LoginResponse extends CommonResponse {
    private AuthAndAccessTokens tokens;
}
