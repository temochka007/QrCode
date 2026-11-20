package com.example.postgres.controller;

import com.example.postgres.dto.QrCodeResponseDto;
import com.example.postgres.entity.Member;
import com.example.postgres.entity.QrCode;
import com.example.postgres.service.MemberService;
import com.example.postgres.service.QrCodeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/qr-codes")
public class QrCodeController {
    private final QrCodeService qrCodeService;
    private final MemberService memberService;

    public QrCodeController(QrCodeService qrCodeService, MemberService memberService) {
        this.qrCodeService = qrCodeService;
        this.memberService = memberService;
    }
    @PostMapping("/{uuid}/replace")
    public QrCodeResponseDto replaceQrCode(@PathVariable UUID uuid){
       return qrCodeService.replaceQrCode(uuid);
    }
    @PostMapping("/member/{memberId}")
    public QrCode postQrCode(@PathVariable Long memberId){
        Member member = memberService.getById(memberId);

        return qrCodeService.createQrCode(member);
    }

}
