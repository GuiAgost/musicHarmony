package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {

        // Implementar a mesma coisa para todas as classes Controller
        HttpSession session = request.getSession();
        System.out.println("Sessão: " + session.getId());
        if (session.getAttribute("userIsLogged") == null ||
                session.getAttribute("userIsLogged").equals("")) {
            return "redirect:/login";
        } else{
            System.out.println("Estou no homeController");
            return "home";
        }

    }
}
