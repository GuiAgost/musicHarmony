package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("aulas")
public class AulasController {

    @GetMapping
    public String aulas(){
        System.out.println("Entrei na aula");
        return "aulas";
    }

    @GetMapping("moduloConceito")
    public String moduloConceito(){
        return "aulas/moduloConceito";
    }

    @GetMapping("moduloTetrade")
    public String moduloTetrade(){
        return "aulas/moduloTetrade";
    }

    @GetMapping("moduloTriade")
    public String moduloTriade(){
        return "aulas/moduloTriade";
    }

    @GetMapping("moduloTransposicao")
    public String moduloTransposicao(){
        return "aulas/moduloTransposicao";
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo o usuario: " + session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}
