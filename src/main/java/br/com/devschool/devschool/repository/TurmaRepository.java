package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    Optional<Turma> findByNome(String nome);

}
