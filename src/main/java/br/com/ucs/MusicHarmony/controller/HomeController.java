package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            return "home";
        }
    }
}
