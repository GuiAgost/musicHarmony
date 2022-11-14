package br.com.ucs.MusicHarmony.controller;

import br.com.ucs.MusicHarmony.model.Questions;
import br.com.ucs.MusicHarmony.model.User;
import br.com.ucs.MusicHarmony.repository.QuestionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class QuizControllerTest {

    public static final String ANSWER = "A";

    @Mock
    QuestionsRepository questionsRepository;

    @InjectMocks
    QuizController quizController;

    private Questions questions;
    private Optional<Questions> optionalQuestions;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    private void startUser() {
        questions = new Questions(ANSWER);
        optionalQuestions = Optional.of(new Questions(ANSWER));
    }


    @Test
    void questions() {
//        QuizController quiz = new QuizController();

        when(questionsRepository.findById(any())).thenReturn(optionalQuestions);

        Optional<Questions> response = questionsRepository.findById(1);
        List<String> answer = response.stream().map(Questions::getAnswer).toList();
        System.out.println(answer);
        System.out.println(ANSWER);

        //assertEquals(User.class, response.getClass());
        assertEquals("[" + ANSWER + "]", response.stream().map(Questions::getAnswer).toList());

    }

    @Test
    void questionsDois() {
    }

    @Test
    void questionsTres() {
    }

    @Test
    void questionsQuatro() {
    }

    @Test
    void questionsCinco() {
    }

    @Test
    void questionsSeis() {
    }

    @Test
    void questionsSete() {
    }

    @Test
    void questionsOito() {
    }

    @Test
    void questionsNove() {
    }

    @Test
    void questionsDez() {
    }

    @Test
    void questionsOnze() {
    }

    @Test
    void questionsDoze() {
    }
}