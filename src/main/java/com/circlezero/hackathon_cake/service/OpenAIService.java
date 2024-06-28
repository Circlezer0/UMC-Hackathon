package com.circlezero.hackathon_cake.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class OpenAIService {

    private static final String API_URL = "https://api.openai.com/v1/images/generations";
    private static final String API_KEY = "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";  // 여기에 API 키를 입력하세요
    private static final String PROMPT_DEFAULT_MESSAGE = ". reality cake.";
    public String generateImage(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json");

        Map<String, Object> body = new HashMap<>();
        body.put("prompt", prompt + PROMPT_DEFAULT_MESSAGE);
        body.put("n", 4);  // 생성할 이미지 수
        body.put("size", "1024x1024");  // 이미지 크기
        body.put("model", "dall-e-2");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("response.getBody() = " + response.getBody());
            return response.getBody();
        } else {
            System.out.println("링크 접속 에러");
            throw new RuntimeException("Failed to generate image. Status Code: " + response.getStatusCode());
        }
    }
}