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
    public String questionarios(){
        System.out.println("Estou no questionario");
        return "questoes/questionarios";
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo o usuario: " + session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}
