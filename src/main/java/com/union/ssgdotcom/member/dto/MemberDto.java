package com.union.ssgdotcom.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
}
