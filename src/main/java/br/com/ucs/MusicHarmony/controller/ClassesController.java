package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.enums.ClassModule;
import br.com.ucs.MusicHarmony.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping
    public String aulas(HttpServletRequest request){
        return redirectToLoginIfNotAuthenticated(request, "aulas");
    }

    @GetMapping("moduloConceito")
    public String conceptModule(HttpServletRequest request){
        return redirectToLoginIfNotAuthenticated(request, ClassModule.CONCEPT.getView());
    }

    @GetMapping("moduloTetrade")
    public String tetradModule(HttpServletRequest request){
        return redirectToLoginIfNotAuthenticated(request, ClassModule.TETRAD.getView());
    }

    @GetMapping("moduloTriade")
    public String triadModule(HttpServletRequest request){
        return redirectToLoginIfNotAuthenticated(request, ClassModule.TRIAD.getView());
    }

    @GetMapping("moduloTransposicao")
    public String transpositionModule(HttpServletRequest request){
        return redirectToLoginIfNotAuthenticated(request, ClassModule.TRANSPOSITION.getView());
    }

    private String redirectToLoginIfNotAuthenticated(HttpServletRequest request, String viewName) {
        return userSessionService.isUserNotLogged(request) ? "redirect:/login" : viewName;
    }

    // Faz logout quando o usuário clicar link "Logout". Além disso, exclui a chave da sessão
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        userSessionService.invalidateSession(request);
        return "redirect:/login";
    }
}