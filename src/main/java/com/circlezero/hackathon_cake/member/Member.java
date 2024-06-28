package com.circlezero.hackathon_cake.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // DB에서의 id
    private String userId;      // 유저의 id (소셜로그인 : provider + "_" + providerId)
    private String password;    // form login 에서 pw
    private String name;        // 실명
    private String nickname;    // 닉네임
    private String email;       // oauth2 로그인에서 유저를 구분하기 위한 email
    private String provider;    // 로그인 API의 출처 (ex: Google, Kakao, Github)
    private String providerId;  // 구글에서 해당 유저의 고유 ID
    @Enumerated(EnumType.STRING)
    private Role role;          // 유저의 페이지 관람 권한


    @Builder
    public Member(String userId, String name, String nickname, String email,
                  String password, Role role, String provider, String providerId) {
        this.userId = userId;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public Member() { }

    public Member update(String name) {
        this.name = name;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}