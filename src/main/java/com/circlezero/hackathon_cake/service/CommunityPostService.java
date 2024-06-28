package com.circlezero.hackathon_cake.service;

import com.circlezero.hackathon_cake.domain.CommunityPost;
import com.circlezero.hackathon_cake.repository.CommunityPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityPostService {

    private final CommunityPostRepository communityPostRepository;

    public List<CommunityPost> getCommunityPosts() {
        return communityPostRepository.findAll();
    }
}
