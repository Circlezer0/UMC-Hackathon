package com.circlezero.hackathon_cake.web.dto.CommunityPostDTO;

import com.circlezero.hackathon_cake.domain.CommunityPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class CommunityPostResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CakeImgDTO {
        String image_url;
        String name;
        String title;
        String body;
        LocalDateTime createdAt;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostsResultDTO {
        List<CommunityPost> communityPostList;
    }
}
