package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotBlank;

public class RequestQuestion {

    @Autowired
    QuestionsRepository questionsRepository;

    @NotBlank
    private Long id;
    @NotBlank
    private char answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getAnswer() {
        return answer;
    }

    public void setAnswer(char answer) {
        this.answer = answer;
    }
}
