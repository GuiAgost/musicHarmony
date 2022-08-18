package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.dto.RequisicaoCadastro;
import br.com.ucs.MusicHarmony.model.Usuario;
import br.com.ucs.MusicHarmony.model.repository.UsuarioRepository;
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
        System.out.println("Estou no CadastroController");
        return "cadastro/formulario";
    }

    @PostMapping("/novoUsuario")
    public String salvar(RequisicaoCadastro requisicao){
        System.out.println("Estou aqui no CadastroController");
        System.out.println("Salvando o usuário...");

        // Implementar a lógica se o usuário digitado já existe no banco
        // https://pt.stackoverflow.com/questions/391238/cadastrar-no-spring-boot
        // Se sucesso:
        // https://cursos.alura.com.br/forum/topico-cadastro-usuario-33066
        // https://cursos.alura.com.br/forum/topico-validar-livro-existente-no-banco-25819

        Usuario usuario = requisicao.toUsuario();
        usuarioRepository.save(usuario);
        System.out.println("Salvou");
        return "redirect:/login";
    }
}
// http://localhost:8080/cadastro/formulario
