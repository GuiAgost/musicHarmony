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

@Controller
@RequestMapping("cadastro")
public class FormController {

    @Autowired
    private UserRepository usuarioRepository;

    @GetMapping("formulario")
    public String form(){
        System.out.println("Cadastro");
        return "cadastro/formulario";
    }

    @PostMapping("/formulario")
    public String toSave(Model model, RequestRegistration request, BindingResult registrationError){

        User user = usuarioRepository.findByUsername(request.getUsername());
        if (user != null && (request.getUsername().equals(user.getUsername()) ||
                (request.getPassword().equals(user.getPassword())))){
            System.out.println("Usuário existente!!");
            model.addAttribute("registrationError", registrationError);
        } else {
            System.out.println("Cadastrando o usuário...");
            System.out.println("Salvando o usuário...");
            User usuario = request.toUsuario();
            usuarioRepository.save(usuario);

            System.out.println("Salvou");
            return "redirect:/login";
        }
        return null;
    }
}