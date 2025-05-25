package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestChord;
import br.com.ucs.MusicHarmony.interfaces.HarmonyStrategy;
import br.com.ucs.MusicHarmony.repository.ChordRepository;
import br.com.ucs.MusicHarmony.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("consultas")
public class QueriesController {

    @Autowired
    ChordRepository chordRepository;

    @Autowired
    private TriadService triadService;

    @Autowired
    private TetradService tetradService;

    @Autowired
    ChordImageService chordImageService;

    @GetMapping("triade")
    public String triad(HttpServletRequest request, Model model, Object errorsChord){
        if (getLogged(request)) return "redirect:/login";
        return handleHarmonyRequest(triadService, request, model, errorsChord, "consultas/triade", "resultTriad");
    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model, Object errorsChord){
        if (getLogged(request)) return "redirect:/login";
        return handleHarmonyRequest(tetradService, request, model, errorsChord, "consultas/tetrade", "resultTetrad");
    }

    private String handleHarmonyRequest(HarmonyStrategy strategy, HttpServletRequest request, Model model, Object errorsChord, String viewName, String resultAttributeName) {
        String chord = request.getParameter("chord");
        HttpSession session = request.getSession();
        if (chord != null) {
            String result = strategy.process(chord);
            if (result.equals("Acorde inválido")) {
                model.addAttribute("errorsChord", errorsChord);
                clear(session);
            } else {
                session.setAttribute("chord", chord);
                model.addAttribute(resultAttributeName, result);
            }
        } else {
            clear(session);
        }
        return viewName;
    }

    @GetMapping("acordes")
    public String chords(HttpServletRequest request, RequestChord requestChord, Model model, BindingResult wrong) {
        HttpSession session = request.getSession();
        if (getLogged(request)) return "redirect:/login";

        // Mostra todas as imagens atribuídas
        session.setAttribute("listImg", chordImageService.findAllChordImagesBase64());

        // Exibir a imagem pesquisada
        String chord = request.getParameter("chord");
        if (request.getParameter("chord") != null) {
            // Deixa o valor gravado no campo
            session.setAttribute("chord", chord);
            // Optional retorna string chord do banco de dados
            Optional<String> img = chordImageService.findChordImageByName(chord);
            if (img.isPresent()) {
                // Mostra a imagem pesquisada
                session.setAttribute("img", img.get());
            } else {
                model.addAttribute("wrong", wrong);
                clear(session);
            }
        } else {
            clear(session);
        }

        return "consultas/acordes";
    }

    // Faz a remoção de valores do campo
    @PostMapping("voltar")
    public void clear(HttpSession session) {
        session.removeAttribute("chord");
        session.removeAttribute("semitone");
        session.removeAttribute("img");
    }

    // Fax logout quando o usuário clicar link "Logout". Além disso, exclui a chave da sessão
    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }

    // Caso o usuário não esteja logado, retorna false
    Boolean getLogged(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        return userExist.existsUsers(request);
    }
}