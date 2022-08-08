package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
