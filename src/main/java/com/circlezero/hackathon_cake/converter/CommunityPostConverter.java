package com.circlezero.hackathon_cake.converter;

import com.circlezero.hackathon_cake.domain.CommunityPost;
import com.circlezero.hackathon_cake.web.dto.CommunityPostDTO.CommunityPostResponseDTO;

import java.util.List;

public class CommunityPostConverter {
    public static CommunityPostResponseDTO.PostsResultDTO toPostsResultDTO(List<CommunityPost> lists){
        return CommunityPostResponseDTO.PostsResultDTO.builder()
                .communityPostList(lists)
                .build();
    }
}
