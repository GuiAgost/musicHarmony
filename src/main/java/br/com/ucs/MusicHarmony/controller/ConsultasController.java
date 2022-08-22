package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.service.ExisteSessaoService;
import br.com.ucs.MusicHarmony.model.service.SairService;
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
    public String triade(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tríade");
            return "consultas/triade";
        }
    }

    @GetMapping("tetrade")
    public String tetrade(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tétrade");
            return "consultas/tetrade";
        }
    }

    @GetMapping("transposicao")
    public String transposicao(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Transposição");
            return "consultas/transposicao";
        }
    }

    @GetMapping("acordes")
    public String acordes(HttpServletRequest request){
        ExisteSessaoService userExist = new ExisteSessaoService();
        Boolean logged = userExist.existeUsario(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Acordes");
            return "consultas/acordes";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        SairService logout = new SairService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
