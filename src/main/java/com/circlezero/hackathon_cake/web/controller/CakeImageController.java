package com.circlezero.hackathon_cake.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CakeImageController {


    @PostMapping("/api.openai.com/v1/images/generations")
    public String generateImage() {

        return null;
    }

}
