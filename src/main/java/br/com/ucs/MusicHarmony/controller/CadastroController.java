package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequisicaoCadastro;
import br.com.ucs.MusicHarmony.model.Usuario;
import br.com.ucs.MusicHarmony.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        System.out.println("Cadastro");
        return "cadastro/formulario";
    }

    @PostMapping("/formulario")
    public String salvar(Model model, RequisicaoCadastro request, BindingResult registrationError){

        Usuario user = usuarioRepository.findByUsername(request.getUsername());
        if (user != null && (request.getUsername().equals(user.getUsername()) &&
                (request.getPassword().equals(user.getPassword())))){
            System.out.println("Usuário existente!!");
            model.addAttribute("registrationError", registrationError);
            //return "redirect:/cadastro/formulario";
        } else {
            System.out.println("Cadastrando o usuário...");
            System.out.println("Salvando o usuário...");
            Usuario usuario = request.toUsuario();
            usuarioRepository.save(usuario);

            System.out.println("Salvou");
            return "redirect:/login";
        }

        // Implementar a lógica se o usuário digitado já existe no banco
        // https://pt.stackoverflow.com/questions/391238/cadastrar-no-spring-boot
        // Se sucesso:
        // https://cursos.alura.com.br/forum/topico-cadastro-usuario-33066
        // https://cursos.alura.com.br/forum/topico-validar-livro-existente-no-banco-25819

//        Usuario usuario = request.toUsuario();
//        usuarioRepository.save(usuario);
//        System.out.println("Salvou");
//        return "redirect:/login";
        return null;
    }
}
// http://localhost:8080/cadastro/formulario
