package com.codecool.crudinventorymanagementapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String login() {
        return "/login";
    }

    @GetMapping("/login")
    public String loginHome() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/403";
    }

}
