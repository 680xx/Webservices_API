package com.example.webservices_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/check")
    public String check() {
        return "You are authenticated!";
    }
}
