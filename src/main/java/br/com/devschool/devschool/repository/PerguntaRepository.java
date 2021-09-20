package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Pergunta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PerguntaRepository extends JpaRepository<Pergunta, Integer> {

	@Query("SELECT p FROM Pergunta p "
			+ "JOIN p.disciplina d "
			+ "WHERE (d.id = :disciplinaId OR null = :disciplinaId)"
			)
	List<Pergunta> findAllByDisciplinaId(@Param(value = "disciplinaId") Integer disciplinaId);

	List<Pergunta> findByDisciplinaAreaId(Integer areaId);

//    List<Pergunta> findByArea_Id(Integer areaId);
}
