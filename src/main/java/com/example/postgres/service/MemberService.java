package com.example.postgres.service;

import com.example.postgres.entity.Member;
import com.example.postgres.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member save(Member member){
        return memberRepository.save(member);
    }

    Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }
    public Member getById(Long id){
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден"));
        return member;
    }
    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Member update (Long id, Member updatedMember){
        Member member =  memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Участник не найден"));

        member.setFirstName(updatedMember.getFirstName());
        member.setLastName(updatedMember.getLastName());
        member.setMiddleName(updatedMember.getMiddleName());

        return memberRepository.save(member);
    }

    public boolean existsById(Long id){
        boolean exists = memberRepository.existsById(id);

        return exists;
    }


}
