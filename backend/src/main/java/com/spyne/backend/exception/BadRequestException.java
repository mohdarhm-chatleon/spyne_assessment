package com.spyne.backend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends BaseException {
    public BadRequestException(Integer code, String message) {
        super(code, message);
    }
}
