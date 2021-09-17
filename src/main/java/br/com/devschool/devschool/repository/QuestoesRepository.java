package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Questoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestoesRepository extends JpaRepository<Questoes, Integer> {
}
