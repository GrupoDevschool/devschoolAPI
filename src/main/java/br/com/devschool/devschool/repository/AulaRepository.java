package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AulaRepository extends JpaRepository<Aula, Integer> {
}
