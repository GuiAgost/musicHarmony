package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CadastroController {

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        Usuario usuario = new Usuario();
        usuario.setNome("Guilherme");
        usuario.setEmail("gui.agostini@hotmail.com");
        usuario.setSenha("12345");
        usuario.setId(1);

        // ===========================================//
        //List<Usuario> usuarios = Arrays.asList(usuario);
        //List<Usuario> usuarios = List.of(usuario); // Busca a lista de usuários (opcional)
        //model.addAttribute("usuarios", usuarios); // Adiciona a lista de usuários (opcional)
        // ===========================================//

        return "cadastro";
    }
}

// http://localhost:8080/cadastro
