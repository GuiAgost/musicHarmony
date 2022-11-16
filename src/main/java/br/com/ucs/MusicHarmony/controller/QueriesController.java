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
        TriadService answer = new TriadService();

        String chord;
        HttpSession session = request.getSession();
        Boolean logged = getLogged(request);

        if (logged){
            return "redirect:/login";
        } else{
            if(request.getParameter("chord") != null) {
                // Recebe o valor do campo digitado
                chord = request.getParameter("chord");
                if (answer.chordTriad(chord).equals("Acorde inválido")){
                    model.addAttribute("errorsChord", errorsChord);
                    clear(session);
                }else{
                    // Deixa gravado o valor no campo
                    session.setAttribute("chord", chord);
                    // Retorna a resposta
                    model.addAttribute("resultTriad", answer.chordTriad(chord));
                }
            } else {
                // Limpa os campos ao clicar botão "Voltar"
                clear(session);
            }
            return "consultas/triade";
        }
    }

    @GetMapping("tetrade")
    public String tetrad(HttpServletRequest request, Model model, Object errorsChord){
        TetradService answer = new TetradService();

        // return getTriadAndTetrad(request, model, errorsChord, "consultas/tetrade");

        String chord;
        HttpSession session = request.getSession();
        Boolean logged = getLogged(request);

        if (logged){
            return "redirect:/login";
        } else{
            if(request.getParameter("chord") != null) {
                // Recebe o valor do campo digitado
                chord = request.getParameter("chord");
                if (answer.chordTetrad(chord).equals("Acorde inválido")){
                    model.addAttribute("errorsChord", errorsChord);
                    clear(session);
                }else{
                    // Deixa gravado o valor no campo
                    session.setAttribute("chord", chord);
                    // Retorna a resposta
                    model.addAttribute("resultTetrad", answer.chordTetrad(chord));
                }
            }else {
                // Limpa os campos ao clicar botão "Voltar"
                clear(session);
            }
            return "consultas/tetrade";
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
            // Exibir todas imagens
            List<ChordImage> listImages = chordRepository.findByImage();
            List<byte[]> imageDatabase = listImages.stream().map(ChordImage::getImage).toList();
            List<String> listImg = new ArrayList<>();
            // Itera a lista de imagem para fazer a conversão para Base64 e atribui as imagens para listImg
            for (int i = 0; i < imageDatabase.toArray().length; i++){
                String imagem  = Base64.getMimeEncoder().encodeToString(imageDatabase.get(i));
                listImg.add(imagem);
            }
            // Mostra todas as imagens atribuídas
            session.setAttribute("listImg", listImg);
            // Exibir a imagem pesquisada
            if (request.getParameter("chord") != null) {
                // Recebe o valor do campo digitado
                chordTyped = request.getParameter("chord");
                // Faz concatenação
                String chord = "[" + chordTyped + "]";
                // Deixa o valor gravado no campo
                session.setAttribute("chord", chordTyped);
                // Optional retorna string chord do banco de dados
                Optional<ChordImage> chordImage = chordRepository.findByChordName(requestChord.getChordName(chordTyped));
                String chordDatabase = String.valueOf(chordImage.stream().map(ChordImage::getChordName).toList());

                if (chord.equals(chordDatabase)) {
                    // Ao encontrar o string chord conforme pesquisado, busca a imagem
                    List<byte[]> image = chordImage.stream().map(ChordImage::getImage).toList();
                    // Faz conversão para Base64
                    String img = Base64.getMimeEncoder().encodeToString(image.iterator().next());
                    // Mostra a imagem pesquisada
                    session.setAttribute("img", img);
                } else {
                    model.addAttribute("wrong", wrong);
                    // Limpa valor do campo quando ocorre alerta
                    clear(session);
                }
            } else {
                // Limpa os campos ao clicar botão "Voltar"
                clear(session);
            }
            return "consultas/acordes";
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
                clear(session);
            }
            return "consultas/transposicao";
        }
    }

    // Faz a remoção de valores do campo
    @PostMapping("voltar")
    public String clear(HttpSession session) {
        session.removeAttribute("chord");
        session.removeAttribute("semitone");
        session.removeAttribute("img");
        return "redirect:/home";
    }

    // Fax logout quando o usuário clicar link "Logout". Além disso, exclui a chave da sessão
    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }

    // Caso o usuário não esteja logado, retorna false
    private Boolean getLogged(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        return userExist.existsUsers(request);
    }
}