package com.example.postgres.exception;

import java.io.IOException;
import java.io.UncheckedIOException;

public class QrCodeAlreadyUsedException extends RuntimeException {

    public QrCodeAlreadyUsedException(String message){
        super(message);
    }

}
