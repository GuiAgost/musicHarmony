package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Usuario;
import br.com.ucs.MusicHarmony.model.dto.RequisicaoLogin;
import br.com.ucs.MusicHarmony.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String home(RequisicaoLogin request, HttpServletRequest requestSession) {
        Usuario user = usuarioRepository.findByUsername(request.getUsername());

//        System.out.println("Senha digitada: " + request.getPassword());
//        System.out.println("Usuario digitado: " + request.getUsername());
//
//        System.out.println("Senha do banco: " + user.getPassword());
//        System.out.println("Usuario do banco: " + user.getUsername());

        if (user != null && (request.getUsername().equals(user.getUsername()) &&
                (request.getPassword().equals(user.getPassword())))){
            HttpSession sessao = requestSession.getSession();
            sessao.setAttribute("userIsLogged", request.getUsername());
             return "redirect:/home";
        } else {
            System.out.println("Usuário inválido ou null");
            return "redirect:/login";
         }
    }
}