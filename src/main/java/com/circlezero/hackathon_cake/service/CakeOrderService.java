package com.circlezero.hackathon_cake.service;

import com.circlezero.hackathon_cake.converter.CakeOrderConverter;
import com.circlezero.hackathon_cake.domain.mapping.CakeStoreImage;
import com.circlezero.hackathon_cake.repository.CakeOrderRepository;
import com.circlezero.hackathon_cake.web.dto.CakeOrderDTO.CakeOrderRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CakeOrderService {
    private final CakeOrderRepository cakeOrderRepository;

    public CakeStoreImage joinCakeStoreImage(CakeOrderRequestDTO.JoinDto request) {
        CakeStoreImage cakeStoreCakeImage = CakeOrderConverter.toCakeStoreCakeImage(request);
        System.out.println("cakeStoreCakeImage = " + cakeStoreCakeImage);
        return cakeOrderRepository.save(cakeStoreCakeImage);
    }
}
