package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Gestores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestoresRepository extends JpaRepository<Gestores , Integer> {
}
