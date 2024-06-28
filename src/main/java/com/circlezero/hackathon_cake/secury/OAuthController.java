package com.circlezero.hackathon_cake.secury;

import com.circlezero.hackathon_cake.member.Member;
import com.circlezero.hackathon_cake.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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

    @PostMapping("/signinForm/process")
    public String signinProcess(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String passwd){
        Member member = memberService.signInMember(userId, name, passwd);
        return "redirect:/loginForm";
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