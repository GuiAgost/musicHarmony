package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class ExistsSessionService {

    @GetMapping
    public Boolean existsUsers(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Sessão: " + session.getId());
        return session.getAttribute("userIsLogged") == null ||
                session.getAttribute("userIsLogged").equals("");
    }
}
