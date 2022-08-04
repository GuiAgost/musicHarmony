package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequisicaoCadastro;
import br.com.ucs.MusicHarmony.model.Usuario;
import br.com.ucs.MusicHarmony.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastro")
public class CadastroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("formulario")
    public String formulario(){
        return "cadastro/formulario";
    }

    @PostMapping("novoUsuario")
    public String menu(RequisicaoCadastro requisicao){
        Usuario usuario = requisicao.toUsuario();
        usuarioRepository.save(usuario);

        return "redirect:/login";
    }
}

// http://localhost:8080/cadastro
