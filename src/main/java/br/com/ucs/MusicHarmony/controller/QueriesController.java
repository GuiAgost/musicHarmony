package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.InputMismatchException;


@Controller
@RequestMapping("consultas")
public class QueriesController {

    @GetMapping("triade")
    public String triad(HttpServletRequest request, Model model, Object errorsTriade){
        String chord;
        TriadService answer = new TriadService();

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
                    model.addAttribute("resultTriad", answer.chordTriad(chord));
                }
            }
            return "consultas/triade";
        }
    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model, Object errorsTetrade){
        String chord;
        TetradService answer = new TetradService();

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
                    model.addAttribute("resultTetrad", answer.chordTetrad(chord));
                }
            }
            return "consultas/tetrade";
        }
    }

    @GetMapping("transposicao")
    public String transposition(HttpServletRequest request, Model model, Object errorsTransp){
        int semitone;
        String chordNote;
        TranspositionService transp = new TranspositionService();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Transposição");
            try {
                if ((request.getParameter("chordNote") != null) || (request.getParameter("semitone") != null)) {
                    semitone = Integer.parseInt(request.getParameter("semitone"));
                    chordNote = request.getParameter("chordNote");
                    if (chordNote.matches("[0-9]*")) {
                        model.addAttribute("errorsTransp", errorsTransp);
                    } else {
                        model.addAttribute("resultTransp", transp.transposition(semitone, chordNote));
                    }
                }
            }catch (InputMismatchException | NumberFormatException ex){
                model.addAttribute("errorsTransp", errorsTransp);
            }
            return "consultas/transposicao";
        }
    }
    // https://www.alura.com.br/artigos/verificar-se-e-letra-ou-numero-no-java#:~:text=Agora%20precisamos%20verificar%20se%20essa,equipara%20com%20o%20par%C3%A2metro%20passado.

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