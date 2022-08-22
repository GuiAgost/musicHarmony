package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.service.ExisteSessaoService;
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
    public String aulas(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
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
            return "aulas/moduloTransposicao";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo o usuario: " + session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}
