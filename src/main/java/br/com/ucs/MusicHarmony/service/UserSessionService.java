package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Serviço responsável por operações relacionadas à sessão do usuário,
 * como verificação de login, limpeza de atributos e logout.
 */
@Service
public class UserSessionService {

    // Verifica se o usuário não está logado com base na chave "userIsLogged"
    public boolean isUserNotLogged(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null || session.getAttribute("userIsLogged") == null
                || session.getAttribute("userIsLogged").toString().isEmpty());
    }

    // Invalida a sessão do usuário (logout)
    public void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    // Limpa os atributos da sessão usados na aplicação
    public void clearAttributes(HttpSession session) {
        if (session != null) {
            session.removeAttribute("chord");
            session.removeAttribute("semitone");
            session.removeAttribute("img");
        }
    }
}
