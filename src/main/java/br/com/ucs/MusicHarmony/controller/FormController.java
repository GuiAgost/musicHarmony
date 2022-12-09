package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestRegistration;
import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*
 *  Classe que sala o usuário e senha para banco de dados
 */

@Controller
@RequestMapping("cadastro")
public class FormController {

    @Autowired // Injeção de dependência baseada em campo, que usa a instância do repository
    // isso permite que não há necessidade de declarar um construtor para a classe
    private UserRepository usuarioRepository;

    @GetMapping("formulario")
    public String form(){
        return "cadastro/formulario";
    }

    @PostMapping("/formulario")
    public String toSave(Model model, @Valid RequestRegistration request, BindingResult registrationError){
        User user = usuarioRepository.findByUsername(request.getUsername());

        // Compara o usuario e senha do banco de dados, caso exista, retorna a mensagem que existe usuário
        if (user != null && (request.getUsername().equals(user.getUsername()) ||
                (request.getPassword().equals(user.getPassword())))){
            model.addAttribute("registrationError", registrationError);
        } else {
            // Salva o usuário no banco de dados
            User usuario = request.toUsuario();
            usuarioRepository.save(usuario);
            return "redirect:/login";
        }
        return null;
    }
}