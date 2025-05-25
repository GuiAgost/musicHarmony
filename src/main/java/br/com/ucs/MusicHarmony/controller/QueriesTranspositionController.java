package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.TranspositionService;
import br.com.ucs.MusicHarmony.service.ValidationChordService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("consultas")
public class QueriesTranspositionController {

    QueriesController quitClear = new QueriesController();

    @GetMapping("transposicao")
    public String transposition(HttpServletRequest request, Model model, Object errorsChord){
        int semitone;
        String chord;
        TranspositionService transp = new TranspositionService();
        HttpSession session = request.getSession();

        Boolean logged = quitClear.getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            if ((request.getParameter("chordNote") != null) || (request.getParameter("semitone") != null)) {
                // Recebe o valor do campo digitado
                semitone = Integer.parseInt(request.getParameter("semitone"));
                // Deixa o valor gravado no campo
                session.setAttribute("semitone", semitone);
                // Recebe o valor do campo digitado
                chord = request.getParameter("chord");
                // Deixa o valor gravado no campo
                session.setAttribute("chord", chord);
                // Faz validação de String chord
                ValidationChordService val = new ValidationChordService();
                boolean validation = val.validation(chord);
                if (!validation) {
                    model.addAttribute("errorsChord", errorsChord);
                } else {
                    // Se passar validação, chama método da classe para calcular a trasnposição
                    model.addAttribute("resultTransp", transp.transposition(semitone, chord));
                }
            }else {
                // Limpa os campos ao clicar botão "Voltar"
                quitClear.clear(session);
            }
            return "consultas/transposicao";
        }
    }
}
