package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExisteSessaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            return "home";
        }

//        Pensar em criar uma classe e um metodos para todas as páginas web validar
//        se o usuário está logado ou não.
//        HttpSession session = request.getSession();
//        System.out.println("Sessão: " + session.getId());
//        if (session.getAttribute("userIsLogged") == null ||
//                session.getAttribute("userIsLogged").equals("")) {
//            return "redirect:/login";
//        } else{
//            System.out.println("Estou no homeController");
//            return "home";
//        }
    }
}
