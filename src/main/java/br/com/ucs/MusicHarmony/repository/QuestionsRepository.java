package br.com.ucs.MusicHarmony.repository;

import br.com.ucs.MusicHarmony.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Parecida com a lógica do DAO, serve para mapear a consulta e persistir os dados.
@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}