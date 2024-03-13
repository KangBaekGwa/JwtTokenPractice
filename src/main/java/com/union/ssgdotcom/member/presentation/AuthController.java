package com.union.ssgdotcom.member.presentation;

import com.union.ssgdotcom.member.application.AuthService;
import com.union.ssgdotcom.member.vo.LogInRequestVo;
import com.union.ssgdotcom.member.vo.SignUpRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping()
    public void signUp(@RequestBody SignUpRequestVo signUpRequestVo) {
        log.info("signUpRequestVo: {}", signUpRequestVo);
        authService.signUp(signUpRequestVo);
    }

    @PostMapping("/login")
    public void logIn(@RequestBody LogInRequestVo logInRequestVo) {
        log.info("logIn");
        authService.logIn(logInRequestVo);
    }
}
