package com.circlezero.hackathon_cake.security;

import com.circlezero.hackathon_cake.domain.Member;
import com.circlezero.hackathon_cake.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Member> findResult = memberRepository.findMemberByMemberId(userId);
        if(findResult.isEmpty()){
            throw new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다");
        }
        Member member = findResult.get();
        return new PrincipalDetails(member);
    }
}