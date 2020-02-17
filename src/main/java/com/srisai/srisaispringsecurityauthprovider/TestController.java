package com.srisai.srisaispringsecurityauthprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String getDummy() {
        return "Dummy..";
    }

    @GetMapping("/home")
    public String getHome() {
        return "Home..";
    }

    @GetMapping("/user")
    public String getUsers() {
        return "user..";
    }

    @GetMapping("/admin")
    public String getAdmins() {
        return "admin..";
    }
}
