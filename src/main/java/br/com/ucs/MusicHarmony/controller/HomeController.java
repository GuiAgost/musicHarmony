package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/*
 *  Classe que redireciona para página /home
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        // Retorna se existe a chave da sessão, ou seja, se o usuário está logado
        // Caso não esteja logado, o sistema não permite acessar a página diretamente sem fazer login
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            return "home";
        }
    }
}