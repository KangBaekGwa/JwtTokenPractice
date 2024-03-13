package com.union.ssgdotcom.member.application;

import com.union.ssgdotcom.member.domain.Member;
import com.union.ssgdotcom.member.infrastructure.MemberRepository;
import com.union.ssgdotcom.member.vo.LogInRequestVo;
import com.union.ssgdotcom.member.vo.SignUpRequestVo;
import com.union.ssgdotcom.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public void signUp(SignUpRequestVo signUpRequestVo) {

        Member member = this.createMember(signUpRequestVo);
        log.info("member: {}", member);


    }

    @Override
    public void logIn(LogInRequestVo logInRequestVo) {
        Member member = memberRepository.findByLoginId(logInRequestVo.getLoginId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다"));
        log.info("member: {}", member);
        log.info("member.getPassword(): {}", logInRequestVo.getPassword());
        log.info("member.getUsername(): {}", member.getUsername());
        authenticationManager.authenticate(


                new UsernamePasswordAuthenticationToken(
                        member.getUsername(),
                        logInRequestVo.getPassword()
                )
        );
        String token = createToken(member);
        log.info("token: {}", token);

    }

    private Member createMember(SignUpRequestVo signUpRequestVo) {

        UUID uuid = UUID.randomUUID();
//        Member member = new Member(uuid);
//        member.hashPassword(signUpRequestVo.getPassword());
        Member member = Member.builder()
                .loginId(signUpRequestVo.getLoginId())
                .password(signUpRequestVo.getPassword())
                .name(signUpRequestVo.getName())
                .email(signUpRequestVo.getEmail())
                .phone(signUpRequestVo.getPhone())
                .address(signUpRequestVo.getAddress())
                .uuid(uuid.toString())
                .build();
        member.hashPassword(signUpRequestVo.getPassword());
        log.info("member: {}", member);
        return memberRepository.save(member);
    }

    private String createToken(Member member) {
        String jwt = jwtTokenProvider.generateToken(member);
        return jwt;
    }
}
