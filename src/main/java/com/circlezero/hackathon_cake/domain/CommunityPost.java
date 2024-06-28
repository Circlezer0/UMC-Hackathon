package com.circlezero.hackathon_cake.domain;

import com.circlezero.hackathon_cake.domain.common.BaseEntity;
import com.circlezero.hackathon_cake.domain.mapping.MemberCommunityPost;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CommunityPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    private String body;

    @OneToMany(mappedBy = "CommunityPost", cascade = CascadeType.ALL)
    private List<MemberCommunityPost> member_community_postList = new ArrayList<>();

}
