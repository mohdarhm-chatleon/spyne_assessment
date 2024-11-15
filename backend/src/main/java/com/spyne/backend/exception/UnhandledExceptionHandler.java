package com.spyne.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
@Order
public class UnhandledExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(UnhandledExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse onAnyException(Exception e) {
        logger.error("INTERNAL -> logging done from unhandled exception handler -> {}", e.getMessage());
        // Ideally we can send mails and shit here, pretty cool stuff
        return new com.spyne.backend.exception.ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Error");
    }
}
