package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
Classe para verificar se existe a chave do usuário armazenado em cookie.
Caso não exista, retornará false.
 */
// service é um bean gerenciado pelo spring mvc, pra dizer que esta classe é responsável para operar lógica
@Service
public class ExistsSessionService {

    @GetMapping
    public Boolean existsUsers(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // Retorna false se a chave da sessão for nula ou não existe
        return session.getAttribute("userIsLogged") == null ||
                session.getAttribute("userIsLogged").equals("");
    }
}
