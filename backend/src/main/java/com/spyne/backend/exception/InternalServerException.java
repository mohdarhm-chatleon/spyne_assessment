package com.spyne.backend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternalServerException extends BaseException {
    public InternalServerException(Integer code, String message) {
        super(code, message);
    }
}
