package br.com.devschool.devschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.devschool.model.Avaliacao;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{
    List<Avaliacao> findAllByGestor_Id(Integer gestorId);
}
