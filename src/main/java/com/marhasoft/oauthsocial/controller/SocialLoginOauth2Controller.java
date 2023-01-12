package com.marhasoft.oauthsocial.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping
public class SocialLoginOauth2Controller {

    @GetMapping("/")
    public String getIndex(Model model, Authentication authentication) {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = user.getAttributes();

        String name = attributes.getOrDefault("localizedFirstName", attributes.get("name")).toString();

        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
