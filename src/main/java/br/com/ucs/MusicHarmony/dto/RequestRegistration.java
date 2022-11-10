package br.com.ucs.MusicHarmony.dto;


import br.com.ucs.MusicHarmony.model.User;
import javax.validation.constraints.NotBlank;

public class RequestRegistration {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

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

    // Salva o usuário e senha no banco de dados
    public User toUsuario() {
        User usuario = new User();
        usuario.setUsername(username);
        usuario.setPassword(password);
        return usuario;
    }
}
