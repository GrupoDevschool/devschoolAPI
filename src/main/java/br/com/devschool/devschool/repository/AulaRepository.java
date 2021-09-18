package br.com.devschool.devschool.repository;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AulaRepository extends JpaRepository<Aula, Integer> {
    List<Aula> findByDataHora(String dataHora);

    List<Aula> findByTurma_Id(Integer turmaId);
}
