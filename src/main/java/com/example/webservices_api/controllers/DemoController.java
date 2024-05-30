package com.example.webservices_api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/helloadmin")
    @ResponseBody
    @PreAuthorize("hasRole('client_ADMIN')")
    public String helloAdmin() {
        return "Hello admin";
        }

    @GetMapping("/hellouser")
    @ResponseBody
    @PreAuthorize("hasRole('client_USER')")
    public String helloUser() {
        return "Hello user";
        }
}
