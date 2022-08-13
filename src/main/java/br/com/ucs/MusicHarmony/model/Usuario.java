package br.com.ucs.MusicHarmony.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Long id;
    @Column(name="username", nullable=false, unique=true)
    private String username;
    @Column(name="password", nullable=false)
    private String password;
//    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }

    public boolean isEquals(String usuarioCadastrado, String senhaCadastrado) {
        System.out.println("Segunda comparação: Usuario");
        if(!this.username.equals(usuarioCadastrado) || !this.password.equals(senhaCadastrado)) {
            return false;
        } else {
            return true;
        }
    }
}
