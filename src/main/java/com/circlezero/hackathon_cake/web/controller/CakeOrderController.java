package com.circlezero.hackathon_cake.web.controller;

import com.circlezero.hackathon_cake.apiPayload.ApiResponse;
import com.circlezero.hackathon_cake.converter.CakeOrderConverter;
import com.circlezero.hackathon_cake.domain.mapping.CakeStoreImage;
import com.circlezero.hackathon_cake.service.CakeOrderService;
import com.circlezero.hackathon_cake.web.dto.CakeOrderDTO.CakeOrderRequestDTO;
import com.circlezero.hackathon_cake.web.dto.CakeOrderDTO.CakeOrderResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CakeOrderController {

    private final CakeOrderService cakeOrderService;

    @PostMapping("/order/cake")
    public ApiResponse<CakeOrderResponseDTO.JoinResultDTO> cakeOrder(@RequestBody CakeOrderRequestDTO.JoinDto request){
        System.out.println("request = " + request.getAddress());
        System.out.println("request.getCake_type() = " + request.getCake_type());
        System.out.println("request.getDate() = " + request.getDate());

        CakeStoreImage cakeStoreImage = cakeOrderService.joinCakeStoreImage(request);
        return ApiResponse.onSuccess(CakeOrderConverter.toJoinResultDTO(cakeStoreImage));
    }
}
