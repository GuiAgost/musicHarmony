package br.com.ucs.MusicHarmony.repository;

import br.com.ucs.MusicHarmony.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    Questions findQuestionsByAnswer(char answer);
}
