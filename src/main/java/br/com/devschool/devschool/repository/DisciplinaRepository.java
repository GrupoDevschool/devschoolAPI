package br.com.devschool.devschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.devschool.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{

	List<Disciplina> findAllByArea_Id(Integer areaId);
}
