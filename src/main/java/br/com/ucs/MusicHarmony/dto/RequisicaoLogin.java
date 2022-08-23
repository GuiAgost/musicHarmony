package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotBlank;

public class RequisicaoLogin {
    @Autowired
    UsuarioRepository usuarioRepository;

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

}