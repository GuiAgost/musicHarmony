package br.com.ucs.MusicHarmony.controller;

//import br.com.ucs.MusicHarmony.dto.RequestChord;
//import br.com.ucs.MusicHarmony.model.Chord;
//import br.com.ucs.MusicHarmony.repository.ChordRepository;
import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("consultas")
public class QueriesController {

//    @Autowired
//    ChordRepository chordRepository;

    @GetMapping("triade")
    public String triad(HttpServletRequest request /*, RequestChord requestChord*/){
//        Chord chord = chordRepository.findByChord(requestChord.getChord());
//        System.out.println("Acorde digitado: " + chord);

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tríade");
            if(request.getParameter("chord") != null) {
                System.out.println("Acorde informado: " + request.getParameter("chord"));
            }
            return "consultas/triade";
        }

    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request){
        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tétrade");
            return "consultas/tetrade";
        }
    }

    @GetMapping("transposicao")
    public String transposition(HttpServletRequest request){
        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Transposição");
            return "consultas/transposicao";
        }
    }

    @GetMapping("acordes")
    public String chords(HttpServletRequest request){
        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Acordes");
            return "consultas/acordes";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }

    private Boolean getLogged(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        return userExist.existsUsers(request);
    }
}
