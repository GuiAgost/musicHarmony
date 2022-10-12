package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestQuestion;
import br.com.ucs.MusicHarmony.model.Questionnaires;
import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("questoes")
public class QuizController {

    @Autowired
    QuestionsRepository questionsRepository;

    @GetMapping("questionarios")
    public String quiz(HttpServletRequest requestUser, RequestQuestion requestQuestions, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(requestUser);
        //Questions questions = questionsRepository.findQuestionsByAnswer(requestQuestions.getAnswer());

        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Questionário");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionarios";
        }
    }

    @PostMapping("questionarios")
    public String questions(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionarios";
    }

    @GetMapping("questionariosDois")
    public String quizDois(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDois");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosDois";
        }
    }

    @PostMapping("questionariosDois")
    public String questionsDois(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosDois";
    }

    @GetMapping("questionariosTres")
    public String quizTres(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioTres");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosTres";
        }
    }

    @PostMapping("questionariosTres")
    public String questionsTres(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosTres";
    }

    @GetMapping("questionariosQuatro")
    public String quizQuatro(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioQuatro");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosQuatro";
        }
    }

    @PostMapping("questionariosQuatro")
    public String questionsQuatro(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosQuatro";
    }

    @GetMapping("questionariosCinco")
    public String quizCinco(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioCinco");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosCinco";
        }
    }

    @PostMapping("questionariosCinco")
    public String questionsCinco(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosCinco";
    }

    @GetMapping("questionariosSeis")
    public String quizSeis(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioSeis");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosSeis";
        }
    }

    @PostMapping("questionariosSeis")
    public String questionsSeis(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosSeis";
    }

    @GetMapping("questionariosSete")
    public String quizSete(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioSete");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosSete";
        }
    }

    @PostMapping("questionariosSete")
    public String questionsSete(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosSete";
    }

    @GetMapping("questionariosOito")
    public String quizOito(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioOito");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosOito";
        }
    }

    @PostMapping("questionariosOito")
    public String questionsOito(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosOito";
    }

    @GetMapping("questionariosNove")
    public String quizNove(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioNove");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosNove";
        }
    }

    @PostMapping("questionariosNove")
    public String questionsNove(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosNove";
    }

    @GetMapping("questionariosDez")
    public String quizDez(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDez");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosDez";
        }
    }

    @PostMapping("questionariosDez")
    public String questionsDez(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosDez";
    }

    @GetMapping("questionariosOnze")
    public String quizOnze(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioOnze");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosOnze";
        }
    }

    @PostMapping("questionariosOnze")
    public String questionsOnze(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosOnze";
    }

    @GetMapping("questionariosDoze")
    public String quizDoze(HttpServletRequest request, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDoze");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionariosDoze";
        }
    }

    @PostMapping("questionariosDoze")
    public String questionsDoze(Questionnaires selected, Model model, HttpServletRequest requestUser) {
        model.addAttribute("selected", selected);
        System.out.println("Resposta selecionado: " + requestUser.getParameter("selected"));

        //    if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

        return "questoes/questionariosDoze";
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
