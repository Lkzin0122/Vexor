package com.vexor.api.exceptions;

import com.vexor.api.dtos.AuthDtos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<AuthDtos.ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(AuthDtos.ApiResponse.error("Invalid request", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AuthDtos.ApiResponse<Void>> handleGeneric(Exception e) {
        return ResponseEntity.internalServerError()
                .body(AuthDtos.ApiResponse.error("Internal server error", e.getMessage()));
    }
}
