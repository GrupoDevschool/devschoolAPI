package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresencaRepository extends JpaRepository<Presenca, Integer> {
    List<Presenca> findByAula(Aula aula);

    List<Presenca> findAllByAluno_Id(Integer aluno);


}
