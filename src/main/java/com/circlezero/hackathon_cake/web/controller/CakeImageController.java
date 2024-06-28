package com.circlezero.hackathon_cake.web.controller;


import com.circlezero.hackathon_cake.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CakeImageController {
    private final OpenAIService openAIService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/image/generate")
    public String generateImage(@RequestParam String prompt) {
        System.out.println("prompt = " + prompt);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return "{\n" +
                "  \"created\": 1719599439,\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"url\": \"https://oaidalleapiprodscus.blob.core.windows.net/private/org-dP3uK5jBI3id25KJikQK65jf/user-NIpTN0zu2nexBbG8a7P3SLiA/img-LPgDxNbE5PfVMOuNOLwnO8E3.png?st=2024-06-28T17%3A30%3A39Z&se=2024-06-28T19%3A30%3A39Z&sp=r&sv=2023-11-03&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-06-28T01%3A41%3A56Z&ske=2024-06-29T01%3A41%3A56Z&sks=b&skv=2023-11-03&sig=PPy1GWkySTVnWUmNFkllNzVt1yFWSwXS9xEfRokIB8w%3D\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"url\": \"https://oaidalleapiprodscus.blob.core.windows.net/private/org-dP3uK5jBI3id25KJikQK65jf/user-NIpTN0zu2nexBbG8a7P3SLiA/img-siBfIKIKaXJXnHufkqCHZbMp.png?st=2024-06-28T17%3A30%3A39Z&se=2024-06-28T19%3A30%3A39Z&sp=r&sv=2023-11-03&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-06-28T01%3A41%3A56Z&ske=2024-06-29T01%3A41%3A56Z&sks=b&skv=2023-11-03&sig=JvWnSqNchE0oeIKYc50Dcu5%2BI0D0FG8BcB1zlSYpCKw%3D\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"url\": \"https://oaidalleapiprodscus.blob.core.windows.net/private/org-dP3uK5jBI3id25KJikQK65jf/user-NIpTN0zu2nexBbG8a7P3SLiA/img-mjmeSPSd9lmdz6mOw0EUnc8R.png?st=2024-06-28T17%3A30%3A39Z&se=2024-06-28T19%3A30%3A39Z&sp=r&sv=2023-11-03&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-06-28T01%3A41%3A56Z&ske=2024-06-29T01%3A41%3A56Z&sks=b&skv=2023-11-03&sig=HXrcEhLRFaQMdkrn6vxnR/qS83IPZALbBa3pcjSxmlo%3D\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"url\": \"https://oaidalleapiprodscus.blob.core.windows.net/private/org-dP3uK5jBI3id25KJikQK65jf/user-NIpTN0zu2nexBbG8a7P3SLiA/img-hYEqg5yN55BDjiwJP0Kalfkt.png?st=2024-06-28T17%3A30%3A39Z&se=2024-06-28T19%3A30%3A39Z&sp=r&sv=2023-11-03&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-06-28T01%3A41%3A56Z&ske=2024-06-29T01%3A41%3A56Z&sks=b&skv=2023-11-03&sig=Sb/i63pXG%2BQ3wPxSrRunlb%2BnMkmdZiznerYxkOYERn8%3D\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        //System.out.println("prompt = " + prompt);
        //return openAIService.generateImage(prompt);
    }

}
