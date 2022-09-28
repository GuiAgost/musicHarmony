package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.service.ExistsSessionService;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("questoes")
public class QuizController {

    @GetMapping("questionarios")
    public String quiz(HttpServletRequest request){
        ExistsSessionService userExist = new ExistsSessionService();
        Boolean logged = userExist.existsUsers(request);
        if (logged){
            return "redirect:/login";
        } else{
            System.out.println("Questionário");
            return "questoes/questionarios";
        }
    }

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
