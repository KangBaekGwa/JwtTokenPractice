package com.union.ssgdotcom.member.presentation;

import com.union.ssgdotcom.member.application.MemberService;
import com.union.ssgdotcom.member.domain.Member;
import com.union.ssgdotcom.member.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {

    private final MemberService memberService;

    public void modifyUserPwd() {
    }

    @Operation(summary = "회원가입", description = "회원가입", tags = { "User Sign" })
    @PostMapping
    public Member createMember(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @Operation(summary = "회원조회", description = "회원조회", tags = { "Get User" })
    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

}
