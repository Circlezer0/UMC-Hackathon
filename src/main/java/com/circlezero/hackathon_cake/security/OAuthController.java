package com.circlezero.hackathon_cake.security;

import com.circlezero.hackathon_cake.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    private final MemberService memberService;

    @GetMapping("/loginForm")
    public String home() {
        return "loginForm";
    }

    @GetMapping("/signinForm")
    public String signinForm(){
        return "signinForm";
    }


    @GetMapping("/private")
    public String privatePage() {
        return "privatePage";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/")
    public String mainPage(Model model){
        boolean isLogined = memberService.isLogined();
        model.addAttribute("isLogined", isLogined);
        System.out.println("isLogined = " + isLogined);
        if(isLogined){
            model.addAttribute("username", memberService.getLoginMemberName());
        }
        return "index";
    }
}