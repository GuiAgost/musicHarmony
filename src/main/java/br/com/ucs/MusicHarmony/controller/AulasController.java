package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.service.ExisteSessaoService;
import br.com.ucs.MusicHarmony.model.service.SairService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("aulas")
public class AulasController {

    @GetMapping
    public String aulas(HttpServletRequest request){

        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Menu Aulas");
            return "aulas";
        }
    }

    @GetMapping("moduloConceito")
    public String moduloConceito(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Conceito Musical");
            return "aulas/moduloConceito";
        }
    }

    @GetMapping("moduloTetrade")
    public String moduloTetrade(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Tétrade");
            return "aulas/moduloTetrade";
        }
    }

    @GetMapping("moduloTriade")
    public String moduloTriade(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Triade");
            return "aulas/moduloTriade";
        }
    }

    @GetMapping("moduloTransposicao")
    public String moduloTransposicao(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Transposição");
            return "aulas/moduloTransposicao";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        SairService logout = new SairService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
