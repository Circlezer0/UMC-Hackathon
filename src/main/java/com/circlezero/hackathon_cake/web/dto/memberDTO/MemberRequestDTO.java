package com.circlezero.hackathon_cake.web.dto.memberDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class MemberRequestDTO {


    @Getter
    public static class JoinDto {
        String name;
        String nickname;
        String password;
        String email;
        String phoneNumber;
    }

    @Getter
    public static class LoginDto {
        String email;
        String password;
    }
}
