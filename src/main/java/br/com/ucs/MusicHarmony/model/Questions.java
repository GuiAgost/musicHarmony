package br.com.ucs.MusicHarmony.model;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Integer id;
    @Column(name="answer", nullable=false)
    private String answer;

    public Integer getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }
}