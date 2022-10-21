package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Scales;
import br.com.ucs.MusicHarmony.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("consultas")
public class QueriesController {

    @GetMapping("triade")
    public String triad(HttpServletRequest request, Model model, Object errorsTriade){
        String chord;
        TriadService answer = new TriadService();
        HttpSession session = request.getSession();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tríade");
            if(request.getParameter("chord") != null) {
                chord = request.getParameter("chord");
                if (answer.chordTriad(chord).equals("Acorde inválido")){
                    model.addAttribute("errorsTriade", errorsTriade);
                }else{
                    session.setAttribute("chord", chord);
                    model.addAttribute("resultTriad", answer.chordTriad(chord));
                }
            } else {
                voltar(session);
            }
            return "consultas/triade";
        }
    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model, Object errorsTetrade){
        String chord;
        TetradService answer = new TetradService();
        HttpSession session = request.getSession();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tétrade");
            if(request.getParameter("chord") != null) {
                chord = request.getParameter("chord");
                if (answer.chordTetrad(chord).equals("Acorde inválido")){
                    model.addAttribute("errorsTetrade", errorsTetrade);
                }else{
                    session.setAttribute("chord", chord);
                    model.addAttribute("resultTetrad", answer.chordTetrad(chord));
                }
            }else {
                voltar(session);
            }
            return "consultas/tetrade";
        }
    }

    @GetMapping("transposicao")
    public String transposition(HttpServletRequest request, Model model, Object errorsTransp){
        int semitone;
        String chord;
//        Scales scale = new Scales();
        TranspositionService transp = new TranspositionService();
        HttpSession session = request.getSession();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Transposição");
                if ((request.getParameter("chordNote") != null) || (request.getParameter("semitone") != null)) {
                    semitone = Integer.parseInt(request.getParameter("semitone"));
                    chord = request.getParameter("chord");
                    ValidationChordService val = new ValidationChordService();
                    boolean validation = val.validation(chord);
                    session.setAttribute("chord", chord);
                    session.setAttribute("semitone", semitone);
                    if (!validation) {
                        model.addAttribute("errorsTransp", errorsTransp);
                    } else {
                        model.addAttribute("resultTransp", transp.transposition(semitone, chord));
                    }
                }else {
                    voltar(session);
                }
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

    @PostMapping("voltar")
    public String voltar (HttpSession session) {
        session.removeAttribute("chord");
        session.removeAttribute("semitone");
        return "redirect:/home";
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