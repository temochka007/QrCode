package com.example.postgres.exception;

public class QrCodeNotFoundException extends RuntimeException{
    public QrCodeNotFoundException(String message){
        super(message);
    }
}
