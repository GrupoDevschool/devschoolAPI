package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AulaRepository extends JpaRepository<Aula, Integer> {
    Optional<Aula> findByDataHora(String dataHora);

}
