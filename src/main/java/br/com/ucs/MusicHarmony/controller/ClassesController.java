package br.com.ucs.MusicHarmony.controller;

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
        UserSessionService userExist = new UserSessionService ();
        boolean logged = userExist.isUserNotLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            return redirect;
        }
    }

    private Boolean getExistsUser(HttpServletRequest request) {
        UserSessionService userExist = new UserSessionService ();
        // Retorna se existe a chave da sessão, ou seja, se o usuário está logado
        // Caso não esteja logado, o sistema não permite acessar a página diretamente sem fazer login
        return userExist.isUserNotLogged(request);
    }

    // Faz logout quando o usuário clicar link "Logout". Além disso, exclui a chave da sessão
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        userSessionService.invalidateSession(request);
        return "redirect:/login";
    }
}