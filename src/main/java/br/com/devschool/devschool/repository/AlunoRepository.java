package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    List<Aluno> findAll();

    Optional<Aluno> findById(Integer matricula);

    void deleteByMatricula(Integer matricula);

    Aluno save(Aluno aluno);
}
