package br.com.ucs.MusicHarmony.service;

import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SairService {

    public void invalidationSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Excluindo a sessão usuario: " + session.getId());
        session.invalidate();
    }
}
