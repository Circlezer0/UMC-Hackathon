package com.circlezero.hackathon_cake.converter;

import com.circlezero.hackathon_cake.domain.enums.CakeType;
import com.circlezero.hackathon_cake.domain.mapping.CakeStoreImage;
import com.circlezero.hackathon_cake.web.dto.CakeOrderDTO.CakeOrderRequestDTO;
import com.circlezero.hackathon_cake.web.dto.CakeOrderDTO.CakeOrderResponseDTO;

import java.time.LocalDateTime;

public class CakeOrderConverter {
    public static CakeOrderResponseDTO.JoinResultDTO toJoinResultDTO(CakeStoreImage cakeStoreCakeImage){
        return CakeOrderResponseDTO.JoinResultDTO.builder()
                .cakeStoreCakeImageId(cakeStoreCakeImage.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static CakeStoreImage toCakeStoreCakeImage(CakeOrderRequestDTO.JoinDto request){

        CakeType cake_type = null;

        switch (request.getCake_type()){
            case 1:
                cake_type = CakeType.Fruit;
                break;
            case 2:
                cake_type = CakeType.Choco;
                break;
            case 3:
                cake_type = CakeType.RiceCake;
                break;
            case 4:
                cake_type = CakeType.Cream;
                break;
            case 5:
                cake_type = CakeType.CreamCheese;
                break;
        }

        return CakeStoreImage.builder()
                .address(request.getAddress())
                .date(request.getDate())
                .cake_type(cake_type)
                .build();
    }
}
