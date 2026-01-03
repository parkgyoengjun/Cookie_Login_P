package com.example.login_practice.controller;

import com.example.login_practice.domain.User;
import com.example.login_practice.service.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieLoginController {

    private final CookieService cookieService;

    public CookieLoginController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response) {
        User user = cookieService.loginCookie();
        if (user != null) {
            Cookie cookie = new Cookie("userId", String.valueOf(user.getUserId()));
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            cookie.setHttpOnly(true);

            response.addCookie(cookie);
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @PostMapping("/logout")
    public String logoutForm(HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");

        response.addCookie(cookie);
        return "redirect:/";
    }
}///
