package br.com.ucs.MusicHarmony.dto;


import br.com.ucs.MusicHarmony.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoCadastro {

        @NotBlank
        private String nome;
        private String email;
        private String senha;
        private String confirmeSenha;

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setConfirmeSenha(confirmeSenha);
        return  usuario;
    }
}
