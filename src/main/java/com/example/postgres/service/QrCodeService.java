package com.example.postgres.service;

import com.example.postgres.dto.QrCodeResponseDto;
import com.example.postgres.entity.Member;
import com.example.postgres.entity.QrCode;
import com.example.postgres.exception.QrCodeAlreadyUsedException;
import com.example.postgres.exception.QrCodeNotFoundException;
import com.example.postgres.repository.MemberRepository;
import com.example.postgres.repository.QrCodeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QrCodeService {
    private final QrCodeRepository qrCodeRepository;
    private final MemberRepository memberRepository;

    public QrCodeService(QrCodeRepository qrCodeRepository, MemberRepository memberRepository) {
        this.qrCodeRepository = qrCodeRepository;
        this.memberRepository = memberRepository;
    }
     public QrCode findByUuid(UUID uuid){
        QrCode qrCode = qrCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Qr Code не найден"));
         return qrCode;
     }

     public QrCode validateQrCode(UUID uuid){
        QrCode qrCode = qrCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new QrCodeNotFoundException("Qr Code не найден"));
        boolean activeQrCode = qrCode.isActive();
        if(!activeQrCode){
            throw new QrCodeAlreadyUsedException("Qr-код не активен");
        }return qrCode;
     }
     public void deactivateQrCode(QrCode qrCode){
        qrCode.setActive(false);
        qrCodeRepository.save(qrCode);
     }
     public QrCode createQrCode(Member member){
         QrCode qrCode = new QrCode(member);
         return qrCodeRepository.save(qrCode);
     }
     @Transactional
      public QrCodeResponseDto replaceQrCode(UUID uuid){
        QrCode qrCode = validateQrCode(uuid);
        Member member = qrCode.getMember();

        deactivateQrCode(qrCode);

        QrCode newActiveQrCode = createQrCode(member);

         QrCodeResponseDto responseDto = new QrCodeResponseDto(
                 member.getFirstName(),
                 member.getLastName(),
                 member.getMiddleName(),
                 newActiveQrCode.getUuid()
         );
        return responseDto;
      }

}
