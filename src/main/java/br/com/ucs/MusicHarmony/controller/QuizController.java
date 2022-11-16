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
    QuestionsRepository questionsRepository;

    // Redireciona a página, se o usuário estiver logado
    @GetMapping("questionarioUm")
    public String quiz(HttpServletRequest requestUser, Model model){
        return getLogged(requestUser, model, "questoes/questionarioUm");
    }

    // Retorna o resultado
    @PostMapping("questionarioUm")
    public String questions(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                            BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 1L);
        return "questoes/questionarioUm";
    }

    @GetMapping("questionarioDois")
    public String quizDois(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioDois");
    }

    @PostMapping("questionarioDois")
    public String questionsDois(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 2L);
        return "questoes/questionarioDois";
    }

    @GetMapping("questionarioTres")
    public String quizTres(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioTres");
    }

    @PostMapping("questionarioTres")
    public String questionsTres(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 3L);
        return "questoes/questionarioTres";
    }

    @GetMapping("questionarioQuatro")
    public String quizQuatro(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioQuatro");
    }

    @PostMapping("questionarioQuatro")
    public String questionsQuatro(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                  BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 4L);
        return "questoes/questionarioQuatro";
    }

    @GetMapping("questionarioCinco")
    public String quizCinco(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioCinco");
    }

    @PostMapping("questionarioCinco")
    public String questionsCinco(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                 BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 5L);
        return "questoes/questionarioCinco";
    }

    @GetMapping("questionarioSeis")
    public String quizSeis(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioSeis");
    }

    @PostMapping("questionarioSeis")
    public String questionsSeis(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        model.addAttribute("selected", selected);
        result(selected, model, request, requestQuestions, wrong, gotItRight, 6L);
        return "questoes/questionarioSeis";
    }

    @GetMapping("questionarioSete")
    public String quizSete(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioSete");
    }

    @PostMapping("questionarioSete")
    public String questionsSete(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 7L);
        return "questoes/questionarioSete";
    }

    @GetMapping("questionarioOito")
    public String quizOito(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioOito");
    }

    @PostMapping("questionarioOito")
    public String questionsOito(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 8L);
        return "questoes/questionarioOito";
    }

    @GetMapping("questionarioNove")
    public String quizNove(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioNove");
    }

    @PostMapping("questionarioNove")
    public String questionsNove(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 9L);
        return "questoes/questionarioNove";
    }

    @GetMapping("questionarioDez")
    public String quizDez(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioDez");
    }

    @PostMapping("questionarioDez")
    public String questionsDez(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                               BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 10L);
        return "questoes/questionarioDez";
    }

    @GetMapping("questionarioOnze")
    public String quizOnze(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioOnze");
    }

    @PostMapping("questionarioOnze")
    public String questionsOnze(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 11L);
        return "questoes/questionarioOnze";
    }

    @GetMapping("questionarioDoze")
    public String quizDoze(HttpServletRequest request, Model model){
        return getLogged(request, model, "questoes/questionarioDoze");
    }

    @PostMapping("questionarioDoze")
    public String questionsDoze(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions,
                                BindingResult wrong, BindingResult gotItRight) {
        result(selected, model, request, requestQuestions, wrong, gotItRight, 12L);
        return "questoes/questionarioDoze";
    }

    private String getLogged(HttpServletRequest request, Model model, String redirect) {
        Boolean logged = getExistsUser(request);
        if (logged){
            return "redirect:/login";
        } else{
            model.addAttribute("selected", new Questionnaires());
            return redirect;
        }
    }

    public void result(Questionnaires selected, Model model, HttpServletRequest request, RequestQuestion requestQuestions, BindingResult wrong, BindingResult gotItRight, Long number) {
        // Retorna ID da questão do banco de dados
        Optional<Questions> answer = questionsRepository.findById(requestQuestions.getId(number));
        // Retorna a resposta do banco de dados
        String resp = String.valueOf(answer.stream().map(Questions::getAnswer).toList());
        // Retorna a resposta selecionado pelo usuário
        model.addAttribute("selected", selected);
        String option = request.getParameter("selected");

        if( (option.equals(resp))){
            // Resposta certa
            model.addAttribute("gotItRight", gotItRight);
        } else {
            // Resposta errada
            model.addAttribute("wrong", wrong);
        }
    }

    private Boolean getExistsUser(HttpServletRequest request) {
        ExistsSessionService userExist = new ExistsSessionService();
        return userExist.existsUsers(request);
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
