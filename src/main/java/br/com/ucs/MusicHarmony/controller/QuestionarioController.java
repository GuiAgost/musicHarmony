package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("questoes")
public class QuestionarioController {

    @GetMapping("questionarios")
    public String questionarios(HttpServletRequest request){

        // Pensar em criar uma classe e um metodos para todas páginas web validar
        // se o usuário está logado ou não.
        HttpSession session = request.getSession();
        System.out.println("Sessão: " + session.getId());
        if (session.getAttribute("userIsLogged") == null ||
                session.getAttribute("userIsLogged").equals("")) {
            return "redirect:/login";
        } else{
            System.out.println("Estou no Questionários");
            return "questoes/questionarios";
        }

//        System.out.println("Estou no questionario");
//        return "questoes/questionarios";
    }

    // Aqui também criar uma classe Logout para escluir a chave da sessão
    // para todas páginas web
    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo o usuario: " + session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}
