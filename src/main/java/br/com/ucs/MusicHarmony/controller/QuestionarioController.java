package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExisteSessaoService;
import br.com.ucs.MusicHarmony.service.SairService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("questoes")
public class QuestionarioController {

    @GetMapping("questionarios")
    public String questionarios(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Questionário");
            return "questoes/questionarios";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        SairService logout = new SairService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
