package com.example.postgres.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(QrCodeAlreadyUsedException.class)
    public ResponseEntity<String> handleQrCodeAlreadyUsed(QrCodeAlreadyUsedException exception){
        String body = new String(exception.getMessage());
        return ResponseEntity.status(409).body(body);
    }

    @ExceptionHandler(QrCodeNotFoundException.class)
    public ResponseEntity<String> handleQrCodeNotFound(QrCodeNotFoundException exception){
        String body = new String(exception.getMessage());
        return ResponseEntity.status(404).body(body);
    }
}
