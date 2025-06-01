package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.dto.RequestRegistration;
import br.com.ucs.MusicHarmony.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*
 *  Classe responsável por cadastrar os novos usuários e senha
 *  Caso o usuário já cadastrado, retorna a mensagem
 */

@Controller
@RequestMapping("cadastro")
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("formulario")
    public String form(){
        return "cadastro/formulario";
    }

    @PostMapping("/formulario")
    public String toSave(Model model, @Valid                                                                                                                                              RequestRegistration request, BindingResult registrationError){

        if (registrationError.hasErrors()) {
            return "cadastro/formulario";
        }

        if (userService.userAlreadyExists(request)) {
            model.addAttribute("registrationError", "Usuário já cadastrado!");
            return "cadastro/formulario";
        }

        userService.saveNewuser(request);
        return "redirect:/login";
    }
}