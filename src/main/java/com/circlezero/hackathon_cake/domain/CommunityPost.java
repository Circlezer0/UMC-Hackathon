package com.circlezero.hackathon_cake.domain;

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
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String body;

    @OneToMany(mappedBy = "communityPost", cascade = CascadeType.ALL)
    private List<MemberCommunityPost> member_community_postList = new ArrayList<>();

    @OneToOne(mappedBy = "communityPost", cascade = CascadeType.ALL)
    private CakeImage cakeImage;
}
