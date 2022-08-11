package br.com.ucs.MusicHarmony.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Long id;
    @Column(name="username", nullable=false, unique=true)
    private String username;
    @Column(name="password", nullable=false, unique=false)
    private String password;
    private boolean enabled;

    public boolean isEquals(String usuarioCadastrado, String senhaCadastrado) {
        if(!this.username.equals(usuarioCadastrado) || !this.password.equals(senhaCadastrado)) {
            return false;
        } else {
            return true;
        }
    }
}
