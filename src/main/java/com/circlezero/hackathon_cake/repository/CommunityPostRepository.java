package com.circlezero.hackathon_cake.repository;

import com.circlezero.hackathon_cake.domain.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityPostRepository  extends JpaRepository<CommunityPost, Long> {
}