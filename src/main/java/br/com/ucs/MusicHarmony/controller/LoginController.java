package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.dto.RequestLogin;
import br.com.ucs.MusicHarmony.repository.UserRepository;
import br.com.ucs.MusicHarmony.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("Entrei login");
        return "login";
    }

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public String home(Model model, RequestLogin request, HttpServletRequest requestSession, BindingResult errors) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && (request.getUsername().equals(user.getUsername()) &&
                (request.getPassword().equals(user.getPassword())))){
            //================MOSTRA OS DADOS NO CONSOLE===========================//
            System.out.println("Senha digitada: " + request.getPassword());
            System.out.println("Usuario digitado: " + request.getUsername());

            System.out.println("Senha do banco: " + user.getPassword());
            System.out.println("Usuario do banco: " + user.getUsername());
            //================MOSTRA OS DADOS NO CONSOLE===========================//
            HttpSession session = requestSession.getSession();
            session.setAttribute("userIsLogged", user);
            System.out.println("Usuario Logado: " + session.getId());
            return "redirect:/home";
        } else {
            System.out.println("Usuário ou senha inválidos!!");
            model.addAttribute("errors", errors);
        }
        return null;
    }

    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}