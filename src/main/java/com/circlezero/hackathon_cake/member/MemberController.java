package com.circlezero.hackathon_cake.member;


import com.circlezero.hackathon_cake.apiPayload.ApiResponse;
import com.circlezero.hackathon_cake.converter.MemberConverter;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberRequestDTO;
import com.circlezero.hackathon_cake.web.dto.memberDTO.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/regist/google")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> joinGoogle(){

        return null;
    }


    @PostMapping("/members/regist")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody MemberRequestDTO.JoinDto request) {
        Member member = memberService.signInMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
