package com.union.ssgdotcom.member.application;

import com.union.ssgdotcom.member.domain.Member;
import com.union.ssgdotcom.member.dto.MemberDto;
import com.union.ssgdotcom.member.dto.ModifyPasswordDto;
import com.union.ssgdotcom.member.infrastructure.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void modifyUserPwd(ModifyPasswordDto modifyPasswordDto, Object userId) {

    }

    @Override
    public Member createMember(MemberDto memberDto) {

        return memberRepository.save(Member.builder()
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .phone(memberDto.getPhone())
                .address(memberDto.getAddress())
                .build());

    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
