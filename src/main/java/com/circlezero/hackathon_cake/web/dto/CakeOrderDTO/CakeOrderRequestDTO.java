package com.circlezero.hackathon_cake.web.dto.CakeOrderDTO;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CakeOrderRequestDTO {
    @Getter
    public static class JoinDto{
        String address;
        Integer cake_type;
        LocalDateTime date;
    }
}
