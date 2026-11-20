package com.example.postgres.controller;

import com.example.postgres.entity.Member;
import com.example.postgres.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member){
        return memberService.save(member);
    }
    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id){
        return memberService.getById(id);
    }
    @PutMapping("/{id}")
    public Member putMember(@PathVariable Long id,@RequestBody Member updatedMember){
        return memberService.update(id, updatedMember);
    }
    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAll();
    }
}
