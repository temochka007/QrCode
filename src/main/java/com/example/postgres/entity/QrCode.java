package com.example.postgres.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "qr_codes")
public class QrCode {
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qr_code", unique = true, nullable = false)
    private UUID uuid;

    @Column(name = "active", nullable = false)
    private boolean active;

    protected QrCode(){
    }

    public QrCode(Member member) {
        this.member = member;
        this.active = true;
        this.uuid = UUID.randomUUID();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Member getMember() {
        return member;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Long getId() {
        return id;
    }

    void setMember(Member member){
        this.member = member;
    }

}
