package com.circlezero.hackathon_cake.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByMemberId(String memberId);
    Optional<Member> findMemberByEmail(String email);
}
