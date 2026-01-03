package com.example.login_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@CookieValue(name = "userId", required = false) String userId, Model model) {

        if (userId == null) {
            model.addAttribute("message", "비로그인상태");
        } else model.addAttribute("message", "로그인상태");
        return "home";
    }
}///
