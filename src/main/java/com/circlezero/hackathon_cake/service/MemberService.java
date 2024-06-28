package com.circlezero.hackathon_cake.service;

import com.circlezero.hackathon_cake.domain.Member;
import com.circlezero.hackathon_cake.repository.MemberRepository;
import com.circlezero.hackathon_cake.domain.enums.Role;
import com.circlezero.hackathon_cake.domain.SessionMember;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberRequestDTO;
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
                .phoneNumber(request.getPhoneNumber())
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