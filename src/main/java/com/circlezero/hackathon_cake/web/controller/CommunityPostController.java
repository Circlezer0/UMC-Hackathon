package com.circlezero.hackathon_cake.web.controller;

import com.circlezero.hackathon_cake.apiPayload.ApiResponse;
import com.circlezero.hackathon_cake.converter.CommunityPostConverter;
import com.circlezero.hackathon_cake.domain.CommunityPost;
import com.circlezero.hackathon_cake.service.CommunityPostService;
import com.circlezero.hackathon_cake.web.dto.CommunityPostDTO.CommunityPostRequestDTO;
import com.circlezero.hackathon_cake.web.dto.CommunityPostDTO.CommunityPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommunityPostController {

    private final CommunityPostService communityPostService;

    @GetMapping("/posts")
    public ApiResponse<CommunityPostResponseDTO.PostsResultDTO> cakeOrder(@RequestBody CommunityPostRequestDTO.PostsDTO request){

        System.out.println("request.getOrderby() = " + request.getOrderby());
        List<CommunityPost> communityPosts = communityPostService.getCommunityPosts();

        return ApiResponse.onSuccess(CommunityPostConverter.toPostsResultDTO(communityPosts));
    }
}
