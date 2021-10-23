package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

    List<Tarefa> findAllByGrupo_Id(Integer grupoId);
}
