package com.circlezero.hackathon_cake.member;

import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberResponseDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BCryptPasswordEncoder encoder;
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;


    public Optional<Member> loginMember(MemberRequestDTO.LoginDto request) {
        Optional<Member> memberByEmail = memberRepository.findMemberByEmail(request.getEmail());
        if (memberByEmail.isPresent()) {
            if (encoder.matches(request.getPassword(), memberByEmail.get().getPassword())) {
                return memberByEmail;
            }
        }
        return Optional.empty();
    }

    public Member signInMember(MemberRequestDTO.JoinDto request){
        Member member = Member.builder()
                .provider("FormLogin")
                .name(request.getName())
                .nickname(request.getNickname())
                .password(encoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
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