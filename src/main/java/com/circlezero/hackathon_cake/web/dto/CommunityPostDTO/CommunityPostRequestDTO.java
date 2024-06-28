package com.circlezero.hackathon_cake.web.dto.CommunityPostDTO;

import lombok.Getter;

import java.time.LocalDateTime;

public class CommunityPostRequestDTO {

    @Getter
    public static class PostsDTO{
        String orderby;
    }
}
