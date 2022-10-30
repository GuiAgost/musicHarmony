package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestChord;
import br.com.ucs.MusicHarmony.model.ChordImage;
import br.com.ucs.MusicHarmony.repository.ChordRepository;
import br.com.ucs.MusicHarmony.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("consultas")
public class QueriesController {

    @Autowired
    ChordRepository chordRepository;

    @GetMapping("triade")
    public String triad(HttpServletRequest request, Model model, Object errorsChord){
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
                    model.addAttribute("errorsChord", errorsChord);
                }else{
                    session.setAttribute("chord", chord);
                    model.addAttribute("resultTriad", answer.chordTriad(chord));
                }
            } else {
                clear(session);
            }
            return "consultas/triade";
        }
    }

    @GetMapping("acordes")
    public String chords(HttpServletRequest request, RequestChord requestChord, Model model, BindingResult wrong){
        HttpSession session = request.getSession();
        String chordTyped;

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else {
            System.out.println("Consulta Acordes");

            // É AQUI QUE MOSTRA TODAS IMAGENS QUANDO ENTRA NA PÁGINA//
            List<ChordImage> listImages = chordRepository.findByImage();
            System.out.println(Arrays.toString(listImages.toArray()));
            List<byte[]> imageDatabase = listImages.stream().map(ChordImage::getImage).toList();

            List<String> listImg = new ArrayList<>();
            for (int i = 0; i < imageDatabase.toArray().length; i++){
                String imagem  = Base64.getMimeEncoder().encodeToString(imageDatabase.get(i));
                listImg.add(imagem);
            }
            session.setAttribute("listImg", listImg);

            if (request.getParameter("chord") != null) {
                chordTyped = request.getParameter("chord");
                String chord = "[" + chordTyped + "]";
                session.setAttribute("chord", chordTyped);
                Optional<ChordImage> chordImage = chordRepository.findByChordName(requestChord.getChordName(chordTyped));
                String chordDatabase = String.valueOf(chordImage.stream().map(ChordImage::getChordName).toList());

                if (chord.equals(chordDatabase)) {
                    System.out.println("Acorde digitado: " + chord);
                    System.out.println("Acorde do Banco de Dados: " + chordDatabase);

                    List<byte[]> image = chordImage.stream().map(ChordImage::getImage).toList();
                    String img = Base64.getMimeEncoder().encodeToString(image.iterator().next());
                    session.setAttribute("img", img);

                } else {
                    System.out.println("Acorde não encontrado!");
                    model.addAttribute("wrong", wrong);
                    clear(session);
                }
            } else {
                clear(session);
            }
            return "consultas/acordes";
        }
    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model, Object errorsChord){
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
                    model.addAttribute("errorsChord", errorsChord);
                }else{
                    session.setAttribute("chord", chord);
                    model.addAttribute("resultTetrad", answer.chordTetrad(chord));
                }
            }else {
                clear(session);
            }
            return "consultas/tetrade";
        }
    }

    @GetMapping("transposicao")
    public String transposition(HttpServletRequest request, Model model, Object errorsChord){
        int semitone;
        String chord;
        TranspositionService transp = new TranspositionService();
        HttpSession session = request.getSession();

        Boolean logged = getLogged(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Consulta Transposição");
                if ((request.getParameter("chordNote") != null) || (request.getParameter("semitone") != null)) {
                    semitone = Integer.parseInt(request.getParameter("semitone"));
                    session.setAttribute("semitone", semitone);

                    chord = request.getParameter("chord");
                    session.setAttribute("chord", chord);

                    ValidationChordService val = new ValidationChordService();
                    boolean validation = val.validation(chord);
                    if (!validation) {
                        model.addAttribute("errorsChord", errorsChord);
                    } else {
                        model.addAttribute("resultTransp", transp.transposition(semitone, chord));
                    }
                }else {
                    clear(session);
                }
            return "consultas/transposicao";
        }
    }

    @PostMapping("voltar")
    public String clear(HttpSession session) {
        session.removeAttribute("chord");
        session.removeAttribute("semitone");
        session.removeAttribute("img");
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