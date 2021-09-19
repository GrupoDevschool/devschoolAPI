package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Questoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestoesRepository extends JpaRepository<Questoes, Integer> {
    List<Questoes> findAllByAvaliacao_Id(Integer avaliacaoId);
}
