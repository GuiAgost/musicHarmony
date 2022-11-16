package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.dto.RequestLogin;
import br.com.ucs.MusicHarmony.repository.UserRepository;
//mport br.com.ucs.MusicHarmony.service.LoginService;
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

    @Autowired // Ao invés de usar o @Autowired, usa construtor
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String home(Model model, RequestLogin request, HttpServletRequest requestSession, BindingResult errors) {
        User user = userRepository.findByUsername(request.getUsername());
        RequestLogin log = new RequestLogin(request);
        boolean logged = log.logado(user);

        if (logged){
            HttpSession session = requestSession.getSession();
            session.setAttribute("userIsLogged", user);
            return "redirect:/home";
        } else {
            model.addAttribute("errors", errors);
        }
        return null;
    }

    // Quando faz logout, remove a chave de sessão do usuário
    @PostMapping("/logout")
    public String logout (HttpServletRequest request) {
        LogoutService logout = new LogoutService();
        logout.invalidationSession(request);
        return "redirect:/login";
    }
}