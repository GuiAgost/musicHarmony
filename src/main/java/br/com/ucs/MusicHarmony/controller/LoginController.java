package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping
    @RequestMapping("/login")
    public String login() {
        System.out.println("Entrei login");

        return "login";

    }

    @RequestMapping("/home")
    public String home() {
       System.out.println("Estou no home");

       // Implementar a logica do login

       return "redirect:/home";
    }
}
// http://localhost:8080/login