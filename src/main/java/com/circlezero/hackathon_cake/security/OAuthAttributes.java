package com.circlezero.hackathon_cake.security;


import com.circlezero.hackathon_cake.member.Member;
import com.circlezero.hackathon_cake.member.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String provider;
    private String providerId;
    private String userId;
    private Role userRole;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name, String email,
                           String provider, String providerId, String userId, Role userRole) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.userId = userId;
        this.userRole = userRole;
    }

    public static OAuthAttributes of(String registrationId, Role userRole, Map<String, Object> attributes) {
        // OAuth2 로그인 진행 시 키가 되는 필드 값 (Primary Key와 같은 의미)을 의미
        // 구글의 기본 코드는 "sub", 후에 네이버 로그인과 구글 로그인을 동시 지원할 때 사용
        String userNameAttributeName;
        if(registrationId.equals("google")){
            userNameAttributeName = "sub";
            return ofGoogle(registrationId, userNameAttributeName, userRole, attributes);
        }
        else if(registrationId.equals("kakao")){
            userNameAttributeName = "id";
            return ofKakao(registrationId, userNameAttributeName, userRole, attributes);
        }
        throw new IllegalArgumentException("Unsupported registrationId: " + registrationId);
    }

    // OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나를 변환해야한다.
    private static OAuthAttributes ofGoogle(String registrationId, String userNameAttributeName, Role userRole, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name(attributes.get("name").toString())
                .email(attributes.get("email").toString())
                .provider(registrationId)
                .providerId((String)attributes.get(userNameAttributeName))
                .userId(registrationId + "_" + attributes.get(userNameAttributeName).toString())
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .userRole(userRole)
                .build();
    }

    private static OAuthAttributes ofKakao(String registrationId, String userNameAttributeName, Role userRole, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name(((Map)attributes.get("properties")).get("nickname").toString())
                .email(null)
                .provider(registrationId)
                .providerId(attributes.get(userNameAttributeName).toString())
                .userId(registrationId + "_" + attributes.get(userNameAttributeName).toString())
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .userRole(userRole)
                .build();
    }


    // User 엔티티 생성 (생성 시점은 처음 가입할 때)
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(name)
                .email(email)
                .role(userRole) // 가입할 때 기본 권한
                .provider(provider)
                .providerId(providerId)
                .userId(userId)
                .build();
    }
}