package br.com.devschool.devschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.devschool.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{
}
