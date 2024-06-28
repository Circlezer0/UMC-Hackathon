package com.circlezero.hackathon_cake.converter;

import com.circlezero.hackathon_cake.domain.Member;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Member member){
        return MemberResponseDTO.LoginResultDTO.builder()
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        return Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
    }
}