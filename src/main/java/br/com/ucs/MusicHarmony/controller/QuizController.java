package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestQuestion;
import br.com.ucs.MusicHarmony.model.Questionnaires;
import br.com.ucs.MusicHarmony.model.Questions;
import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("questoes")
public class QuizController {

    @Autowired
    private QuestionsRepository questionsRepository;

    @GetMapping("questionarios")
    public String quiz(HttpServletRequest requestUser, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(requestUser);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Questionário");
            model.addAttribute("selected", new Questionnaires());
            return "questoes/questionarios";
        }
    }

    @PostMapping("questionarios")
    public String questions(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                            BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 1);
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
    public String questionsDois(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 2);

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
    public String questionsTres(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 3);
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
    public String questionsQuatro(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                  BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 4);
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
    public String questionsCinco(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                 BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 5);
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
    public String questionsSeis(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        model.addAttribute("selected", selected);
        result(selected, model, request, requestQuestions, wrong, gotItRight, 6);
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
    public String questionsSete(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 7);
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
    public String questionsOito(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 8);
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
    public String questionsNove(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 9);
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
    public String questionsDez(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                               BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 10);
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
    public String questionsOnze(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 11);
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
    public String questionsDoze(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 12);
        return "questoes/questionariosDoze";
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }

    private void result(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions, BindingResult wrong, BindingResult gotItRight, Integer number) {
        Optional<Questions> answer = questionsRepository.findById(requestQuestions.getId(number));
        String resp = String.valueOf(answer.stream().map(Questions::getAnswer).toList());
        System.out.println("Resposta do banco: " + resp);

        model.addAttribute("selected", selected);
        String option = request.getParameter("selected");
        System.out.println("Resposta selecionado: " + option);

        if( (option.equals(resp))){
            System.out.println("Resposta correta!");
            model.addAttribute("gotItRight", gotItRight);
        } else {
            System.out.println("Resposta errada!!");
            model.addAttribute("wrong", wrong);
        }
    }
}
