package com.asish.propertyfinder.controller;

import com.asish.propertyfinder.exception.BusinessException;
import com.asish.propertyfinder.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleNotFoundException(BusinessException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(NOT_FOUND).message(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        return buildResponseEntity(errorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }
}
