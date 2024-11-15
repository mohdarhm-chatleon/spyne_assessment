package com.spyne.backend.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CommonResponse {

    private String message;

    public CommonResponse(String message) {
        this.message = message;
    }

    public CommonResponse() {
    }
}
