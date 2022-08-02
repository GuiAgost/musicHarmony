package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private EntityManager entityManager;

    @GetMapping("/login")
    public String Login(Model model) {

//        Query query = entityManager.createQuery("select u from Usuario u", Usuario.class);
//        List<Usuario> usuarios = query.getResultList();
//        model.addAttribute("usuarios", usuarios);
        return "login";
    }
}
// http://localhost:8080/login