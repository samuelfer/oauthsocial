package com.marhasoft.oauthsocial.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SocialLoginOauth2Controller {

    @GetMapping("/")
    public String getIndex(Model model, @AuthenticationPrincipal OAuth2User principal) {
        System.out.println("Chegando por aqui "+principal);
        model.addAttribute("name", principal.getAttribute("name"));
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
