package com.union.ssgdotcom.member.application;

import com.union.ssgdotcom.member.domain.Member;
import com.union.ssgdotcom.member.dto.MemberDto;
import com.union.ssgdotcom.member.dto.ModifyPasswordDto;

public interface MemberService {
    void modifyUserPwd(ModifyPasswordDto modifyPasswordDto, Object userId);
    Member createMember(MemberDto memberDto);

    Member getMember(Long id);
}
