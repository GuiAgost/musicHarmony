package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestQuestion;
import br.com.ucs.MusicHarmony.model.Questions;
import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("questoes")
public class QuizController {

    @Autowired
    QuestionsRepository questionsRepository;

    @GetMapping("questionarios")
    public String quiz(@ModelAttribute Questions questions, HttpServletRequest requestUser, RequestQuestion requestQuestions, Model model){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(requestUser);

        //Questions questions = questionsRepository.findQuestionsByAnswer(requestQuestions.getAnswer());

        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Questionário");

            //model.addAttribute("question", answer);
            char resp = questions.getAnswer();
            System.out.println("Resp: " + resp);
            System.out.println("Outra Forma: " + requestUser.getParameter("answer"));

//            int answer = requestQuestions.getAnswer(); // Aqui pega o valor
            String test = requestUser.getParameter("answer");
            System.out.println("Test: " + test); // Mostra o valor do radiobutton selecionado
//            System.out.println(test);
            model.addAttribute("answer", new Questions());
            System.out.println(model.getAttribute("answer"));

            //System.out.println(model.addAttribute("answer", new Questions()).getAttribute("answer"));
            //System.out.println(model.addAttribute("answer", new Questions()));
            //System.out.println(requestQuestions.getAnswer());
            //quiz(requestQuestions, requestUser);

            // Tentar criar o mesmo metodo daqui, porém com a anotação @PostMaping

//            if(answer != null && answer.equals(aqui pegar o valor do banco)){
//                // Enviar a notificação que acertou a resposta
//            } else {
//                // Enviar a notificação que errou a resposta
//            }

            return "questoes/questionarios";
        }
    }

    //Tentar com post
//    @PostMapping("questionarios")
//    public String quiz(RequestQuestion requestQuestions, HttpServletRequest requestUser) {
//        String answer = requestUser.getParameter("questions");
//        System.out.println("Post: " + answer);
//
//        return "questoes/questionarios";
//    }

    @GetMapping("questionariosDois")
    public String quizDois(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDois");
            return "questoes/questionariosDois";
        }
    }

    @GetMapping("questionariosTres")
    public String quizTres(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioTres");
            return "questoes/questionariosTres";
        }
    }

    @GetMapping("questionariosQuatro")
    public String quizQuatro(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioQuatro");
            return "questoes/questionariosQuatro";
        }
    }

    @GetMapping("questionariosCinco")
    public String quizCinco(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioCinco");
            return "questoes/questionariosCinco";
        }
    }

    @GetMapping("questionariosSeis")
    public String quizSeis(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioSeis");
            return "questoes/questionariosSeis";
        }
    }

    @GetMapping("questionariosSete")
    public String quizSete(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioSete");
            return "questoes/questionariosSete";
        }
    }

    @GetMapping("questionariosOito")
    public String quizOito(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioOito");
            return "questoes/questionariosOito";
        }
    }

    @GetMapping("questionariosNove")
    public String quizNove(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioNove");
            return "questoes/questionariosNove";
        }
    }

    @GetMapping("questionariosDez")
    public String quizDez(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDez");
            return "questoes/questionariosDez";
        }
    }

    @GetMapping("questionariosOnze")
    public String quizOnze(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioOnze");
            return "questoes/questionariosOnze";
        }
    }

    @GetMapping("questionariosDoze")
    public String quizDoze(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("QuestionárioDoze");
            return "questoes/questionariosDoze";
        }
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}
