package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Gestores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestoresRepository extends JpaRepository<Gestores , String> {
    Optional<Gestores> findByNome(String nome);

    void deleteByName(String nome);
}
