package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
