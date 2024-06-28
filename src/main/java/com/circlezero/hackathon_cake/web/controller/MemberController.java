package com.circlezero.hackathon_cake.web.controller;


import com.circlezero.hackathon_cake.apiPayload.ApiResponse;
import com.circlezero.hackathon_cake.converter.MemberConverter;
import com.circlezero.hackathon_cake.domain.Member;
import com.circlezero.hackathon_cake.service.MemberService;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/members/regist")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody MemberRequestDTO.JoinDto request) {
        Member member = memberService.signInMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/members/login")
    public ApiResponse<MemberResponseDTO.LoginResultDTO> login(@RequestBody MemberRequestDTO.LoginDto request) {
        Optional<Member> memberOptional = memberService.loginMember(request);
        if(memberOptional.isPresent()){
            return ApiResponse.onSuccess(MemberConverter.toLoginResultDTO(memberOptional.get()));
        }
        return ApiResponse.onFailure("MEMBER4001", "사용자가 없습니다", null);
    }
}
