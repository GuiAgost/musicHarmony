package br.com.ucs.MusicHarmony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("consultas")
public class ConsultasController {

    @GetMapping("triade")
    public String triade(){
        return "consultas/triade";
    }

    @GetMapping("tetrade")
    public String tetrade(){
        return "consultas/tetrade";
    }

    @GetMapping("transposicao")
    public String transposicao(){
        return "consultas/transposicao";
    }

    @GetMapping("acordes")
    public String acordes(){
        return "consultas/acordes";
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo o usuario: " + session.getId());
        session.invalidate();
        return "redirect:/login";
    }
}
