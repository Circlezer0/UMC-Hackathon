package com.circlezero.hackathon_cake.member;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {
    // SessionUser는 인증된 사용자 정보만 필요하므로 아래 필드만 선언한다.
    private String name;
    private String nickname;
    private String email;
    private String userId;

    public SessionMember(Member user) {
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.userId = user.getMemberId();
    }
}