package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresencaRepository extends JpaRepository<Presenca, Integer> {
}