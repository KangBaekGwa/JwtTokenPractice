package com.union.ssgdotcom.member.vo;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestVo {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;

}
