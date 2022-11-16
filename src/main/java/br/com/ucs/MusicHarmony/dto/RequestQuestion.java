package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestQuestion {

    @Autowired
    QuestionsRepository questionsRepository;

    public Long getId(Long id) {
        return id;
    }
}
