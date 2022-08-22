package br.com.ucs.MusicHarmony.model.dto;

import br.com.ucs.MusicHarmony.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotBlank;

public class RequisicaoLogin {
    @Autowired
    UsuarioRepository usuarioRepository;
    //private static List<Usuario> listaUsuarios = new ArrayList<>();

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

//    public Usuario existeUsuario(String nome, String senha) {
//        for (Usuario login : listaUsuarios) {
//            if (login.isEquals(nome, senha)) {
//                System.out.println("Comparado com sucesso: UsuarioDAO: " + login);
//                return login;
//            }
//        }
//        return null;
//    }
}