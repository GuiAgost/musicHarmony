package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("questoes")
public class QuestionarioController {

    @GetMapping("questionarios")
    public String questionarios(){
        System.out.println("Estou no questionario");
        return "questoes/questionarios";
    }
}
