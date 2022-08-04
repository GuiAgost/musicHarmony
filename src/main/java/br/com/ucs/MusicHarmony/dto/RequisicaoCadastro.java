package br.com.ucs.MusicHarmony.dto;


import br.com.ucs.MusicHarmony.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RequisicaoCadastro {

        @NotBlank
        private String username;
        private String password;

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        return usuario;
    }
}
