package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
    Optional<Trilha> getTrilhaById(Long id);


}
