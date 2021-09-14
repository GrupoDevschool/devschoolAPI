package br.com.devschool.devschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devschool.devschool.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Integer> {

	@Query("SELECT r FROM Resposta r "
			+ "JOIN r.disciplina d "
			+ "WHERE (d.id = :disciplinaId OR null = :disciplinaId)"
			)
	List<Resposta> findAllByDisciplinaId(@Param(value = "disciplinaId") Integer disciplinaId);
	
}
