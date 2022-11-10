package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * Classe para exclusão de chave da sessão do usuário.
 */

@Service
public class LogoutService {

    public void invalidationSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
