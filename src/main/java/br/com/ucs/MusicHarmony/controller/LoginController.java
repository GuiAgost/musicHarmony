package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String Login() {
       // model.addAttribute("nome", "Mundo");
        return "login";
    }
}
// http://localhost:8080/login