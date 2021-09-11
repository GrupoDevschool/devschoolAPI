package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
