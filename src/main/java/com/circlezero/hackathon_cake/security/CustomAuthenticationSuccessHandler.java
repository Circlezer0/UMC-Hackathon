package com.circlezero.hackathon_cake.security;

import com.circlezero.hackathon_cake.member.Member;
import com.circlezero.hackathon_cake.member.MemberRepository;
import com.circlezero.hackathon_cake.member.SessionMember;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String memberId = ((PrincipalDetails) authentication.getPrincipal()).getUserId();
        Optional<Member> member = memberRepository.findMemberByMemberId(memberId);
        HttpSession session = request.getSession();
        member.ifPresent(value -> session.setAttribute("member", new SessionMember(value)));

        response.sendRedirect("/");
    }
}