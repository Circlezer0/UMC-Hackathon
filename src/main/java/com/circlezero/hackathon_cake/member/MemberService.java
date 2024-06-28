package com.circlezero.hackathon_cake.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;


    public Member signInMember(String userId, String name, String passwd){
        Member member = Member.builder()
                .provider("FormLogin")
                .userId(userId)
                .name(name)
                .password(encoder.encode(passwd))
                .role(Role.ADMIN)
                .build();
        memberRepository.save(member);
        return member;
    }

    public boolean isLogined(){
        SessionMember member = (SessionMember) httpSession.getAttribute("member");
        return member != null;
    }

    public String getLoginMemberName(){
        if(!isLogined())return null;
        return ((SessionMember) httpSession.getAttribute("member")).getName();
    }
}