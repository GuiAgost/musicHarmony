package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        System.out.println("Entrei login");
        return "/login";

    }

    @RequestMapping("/home")
    public String home() {
        System.out.println("Estou no home");
        return "home";
    }
}
// http://localhost:8080/login