package com.asish.propertyfinder.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

    private ErrorResponse() {
        timestamp = LocalDateTime.now();
    }
}
