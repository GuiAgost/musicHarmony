package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestLoginTest {

    RequestLoginTest(RequestLogin request) {
    }

    @Test
    void islogado() {
        RequestLogin log = new RequestLogin("Guilherme", "123");
        User user = new User();
        boolean logado = log.logado(user);

        assertTrue(logado);
    }
}