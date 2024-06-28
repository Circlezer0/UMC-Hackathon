package com.circlezero.hackathon_cake.member;

import com.circlezero.hackathon_cake.domain.Review;
import com.circlezero.hackathon_cake.domain.common.BaseEntity;
import com.circlezero.hackathon_cake.domain.mapping.MemberCommunityPost;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // DB에서의 id
    private String memberId;      // 유저의 id (소셜로그인 : provider + "_" + providerId)
    private String password;    // form login 에서 pw
    private String name;        // 실명
    private String nickname;    // 닉네임
    private String email;       // oauth2 로그인에서 유저를 구분하기 위한 email
    private String provider;    // 로그인 API의 출처 (ex: Google, Kakao, Github)
    private String providerId;  // 구글에서 해당 유저의 고유 ID
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;          // 유저의 페이지 관람 권한


    public Member update(String name) {
        this.name = name;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberCommunityPost> memberCommunityPostList = new ArrayList<>();
}