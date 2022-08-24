package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("aulas")
public class ClassesController {

    @GetMapping
    public String aulas(HttpServletRequest request){

        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Menu Aulas");
            return "aulas";
        }
    }

    @GetMapping("moduloConceito")
    public String conceptModule(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Conceito Musical");
            return "aulas/moduloConceito";
        }
    }

    @GetMapping("moduloTetrade")
    public String tetradModule(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Tétrade");
            return "aulas/moduloTetrade";
        }
    }

    @GetMapping("moduloTriade")
    public String triadModule(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Triade");
            return "aulas/moduloTriade";
        }
    }

    @GetMapping("moduloTransposicao")
    public String transpositionModule(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Módulo Transposição");
            return "aulas/moduloTransposicao";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
