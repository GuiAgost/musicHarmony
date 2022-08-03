package br.com.ucs.MusicHarmony.controller;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private EntityManager entityManager;

    @GetMapping("/login")
    public String Login(Model model) {
        return "login";
    }

//    @GetMapping("/menu")
//    public String menu(Model model) {
//        return "redirect:/cadastro/menu";
//    }
}
// http://localhost:8080/login