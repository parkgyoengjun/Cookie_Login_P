package com.example.login_practice.service;

import com.example.login_practice.domain.User;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    public User loginCookie() {
        return new User(1L, "철수");
    }

}///
