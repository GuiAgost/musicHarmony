package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.model.User;
import javax.validation.constraints.NotBlank;


public class RequestLogin {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private final RequestLogin request;

    public RequestLogin(RequestLogin request) {
        this.request = request;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Compara o usuário e a senha digitado com o do banco de dados, se forem iguais retorna true
    public boolean logado(User user) {
        return user != null && (request.getUsername().equals(user.getUsername()) &&
                (request.getPassword().equals(user.getPassword())));
    }
}