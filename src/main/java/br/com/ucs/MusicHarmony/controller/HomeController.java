package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

/*
 *  Classe responsável por redirecionar para a página /home.
 *  Antes do redirecionamento, verifica se a chave da sessão está presente, indicando que o usuário está logado.
 *  Se a chave da sessão não estiver presente, o acesso à página será bloqueado até que o usuário realize o login.
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping
    public String home(HttpServletRequest request) {
        return userSessionService.isUserNotLogged(request) ? "redirect:/login" : "home";
    }
}