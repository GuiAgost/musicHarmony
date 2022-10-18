package br.com.ucs.MusicHarmony.dto;

import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestQuestion {

    @Autowired
    QuestionsRepository questionsRepository;

    public Integer getId(Integer id) {
        return id;
    }
}
