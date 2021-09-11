package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Chamada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadaRepository extends JpaRepository<Chamada, Integer> {
}
