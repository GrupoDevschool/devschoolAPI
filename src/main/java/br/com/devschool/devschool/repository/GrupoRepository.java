package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    Optional<Grupo> findByNome(String nome);

}
