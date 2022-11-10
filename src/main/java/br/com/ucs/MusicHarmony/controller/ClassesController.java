package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * Classe que contém endpoints que redireciona página
 */

@Controller
@RequestMapping("aulas")
public class ClassesController {

    @GetMapping
    public String aulas(HttpServletRequest request){
        return getRedirect(request, "aulas");
    }

    @GetMapping("moduloConceito")
    public String conceptModule(HttpServletRequest request){
        return getRedirect(request, "aulas/moduloConceito");
    }

    @GetMapping("moduloTetrade")
    public String tetradModule(HttpServletRequest request){
        return getRedirect(request, "aulas/moduloTetrade");
    }

    @GetMapping("moduloTriade")
    public String triadModule(HttpServletRequest request){
        return getRedirect(request, "aulas/moduloTriade");
    }

    @GetMapping("moduloTransposicao")
    public String transpositionModule(HttpServletRequest request){
        return getRedirect(request, "aulas/moduloTransposicao");
    }

    private String getRedirect(HttpServletRequest request, String redirect) {
        Boolean logged = getExistUser(request);
        if (logged){
            return "redirect:/login";
        } else{
            return redirect;
        }
    }

    private Boolean getExistUser(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        return userExist.existsUsers(request);
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}