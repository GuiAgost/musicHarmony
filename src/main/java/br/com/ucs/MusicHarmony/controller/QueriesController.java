package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import br.com.ucs.MusicHarmony.service.TetradService;
import br.com.ucs.MusicHarmony.service.TriadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("consultas")
public class QueriesController {

    @GetMapping("triade")
    public String triad(HttpServletRequest request, Model model/*, BindingResult errorsTriade*/){
        //String answerTriade;
        String chord;
        TriadService answer = new TriadService();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tríade");
            if(request.getParameter("chord") != null) {
                chord = request.getParameter("chord");
                System.out.println("Acorde informado: " + chord);
                //answerTriade = answer.chordTriad(chord);
//                if (answer.chordTriad(chord).equals("Acorde inválido")){
//                    model.addAttribute("errorsTriade", errorsTriade);
//                }else{
//                    model.addAttribute("resultTriad", answer.chordTriad(chord));
//                }
                model.addAttribute("resultTriad", answer.chordTriad(chord));
                //triadResult(answerTriade, model, errorsTriade);
            }
            return "consultas/triade";
        }
    }

//    @PostMapping("/triade")
//    public String triadResult(@ModelAttribute String resultTriad, Model model, BindingResult errorsTriade){
////        System.out.println(model.addAttribute("resultTriad", resultTriad));
////        model.addAttribute("resultTriad", resultTriad);
//          if (resultTriad.equals("Acorde inválido")){
//              model.addAttribute("errorsTriade", errorsTriade);
//          }else{
//              model.addAttribute("resultTriad", resultTriad);
//          }
//        return "redirect:/consultas/triade";
//    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model){
//        String answerTetrad;
        String chord;
        TetradService answer = new TetradService();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Tétrade");
            if(request.getParameter("chord") != null) {
                chord = request.getParameter("chord");
                System.out.println("Acorde informado: " + chord);
                model.addAttribute("resultTetrad", answer.chordTetrad(chord));
            }
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
