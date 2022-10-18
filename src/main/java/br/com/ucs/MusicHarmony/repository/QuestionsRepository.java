package br.com.ucs.MusicHarmony.repository;

import br.com.ucs.MusicHarmony.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
}