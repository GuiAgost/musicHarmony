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
    public String home(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        String paramAction = request.getRemoteUser();
//        System.out.println(paramAction);
//        HttpSession session = request.getSession();
//        boolean usuarioNaoEstaLogado = (session.getAttribute("userIsLogged") == null);
//        boolean ehUmaAcaoProtegida = !(paramAction.equals("login"));
//
//        if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
//            System.out.println("Eu não estou logado");
//            return "redirect:/login";
//        }

        System.out.println("Estou no homeController");
        return "home";
    }
}
