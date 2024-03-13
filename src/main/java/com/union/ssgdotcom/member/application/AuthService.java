package com.union.ssgdotcom.member.application;

import com.union.ssgdotcom.member.vo.LogInRequestVo;
import com.union.ssgdotcom.member.vo.SignUpRequestVo;

public interface AuthService {

    void signUp(SignUpRequestVo signUpRequestVo);
    void logIn(LogInRequestVo logInRequestVo);

}
