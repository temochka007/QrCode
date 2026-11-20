package com.example.postgres.dto;

import com.example.postgres.entity.Member;

import java.util.UUID;

public class QrCodeResponseDto {

    private String firstName;
    private String lastName;
    private String middleName;
    private UUID newQrCode;

    public QrCodeResponseDto(String firstName, String lastName, String middleName, UUID newQrCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.newQrCode = newQrCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public UUID getNewQrCode() {
        return newQrCode;
    }

}
