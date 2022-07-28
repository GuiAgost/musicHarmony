package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {

    @GetMapping("/login")
    public String LoginController(Model model) {
        model.addAttribute("nome", "Mundo");
        return "login";
    }
}
