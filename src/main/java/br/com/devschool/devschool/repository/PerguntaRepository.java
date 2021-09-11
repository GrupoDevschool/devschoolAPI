package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {
}
