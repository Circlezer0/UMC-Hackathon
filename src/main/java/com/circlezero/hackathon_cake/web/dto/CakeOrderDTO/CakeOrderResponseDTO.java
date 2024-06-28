package com.circlezero.hackathon_cake.web.dto.CakeOrderDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class CakeOrderResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long cakeStoreCakeImageId;
        LocalDateTime createdAt;
    }
}
