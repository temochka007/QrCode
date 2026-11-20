package com.example.postgres.repository;

import com.example.postgres.entity.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
    Optional<QrCode> findByUuid(UUID uuid);
}
