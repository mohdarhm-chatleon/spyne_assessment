package com.spyne.backend.exception;

public class NotFoundException extends BaseException{
    public NotFoundException(Integer code, String message) {
        super(code, message);
    }
}
