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

    final // Ao invés de usar o @Autowired, usa construtor
    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String home(Model model, RequestLogin request, HttpServletRequest requestSession, BindingResult errors) {
        User user = userRepository.findByUsername(request.getUsername());

        // Compara o usuario e senha do banco de dados
        if (user != null && (request.getUsername().equals(user.getUsername()) &&
                (request.getPassword().equals(user.getPassword())))){
            //================MOSTRA OS DADOS NO CONSOLE===========================//
            System.out.println("Senha digitada: " + request.getPassword());
            System.out.println("Usuario digitado: " + request.getUsername());

            System.out.println("Senha do banco: " + user.getPassword());
            System.out.println("Usuario do banco: " + user.getUsername());
            //================MOSTRA OS DADOS NO CONSOLE===========================//
            // Atribui o nome do usuário no canto esquerdo da tela
            HttpSession session = requestSession.getSession();
            session.setAttribute("userIsLogged", user);
            return "redirect:/home";
        } else {
            System.out.println("Usuário ou senha inválidos!!");
            // Envia a mensagem de erro
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