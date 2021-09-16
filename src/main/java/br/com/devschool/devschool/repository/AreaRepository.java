package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    Optional<Area> findAreaById(Integer id);

}
