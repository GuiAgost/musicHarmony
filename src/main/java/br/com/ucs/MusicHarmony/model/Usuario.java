package br.com.ucs.MusicHarmony.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
// import org.springframework.data.annotation.Id;
// import javax.persistence.GeneratedValue;

// Detalhes sobre lombok: https://medium.com/collabcode/projeto-lombok-escrevendo-menos-c%C3%B3digo-em-java-8fc87b379209

@Getter
@Setter
//@AllArgsConstructor
public class Usuario {

    // @Id @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String senha;


}
