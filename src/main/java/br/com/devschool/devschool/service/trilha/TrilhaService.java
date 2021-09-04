package br.com.devschool.devschool.service.trilha;

import br.com.devschool.devschool.model.dto.TrilhaDTO;
import br.com.devschool.devschool.model.Trilha;

import java.util.List;

public interface TrilhaService {
    List<Trilha> getAllTrilha();

    Trilha getTrilhaById(Long id);

    Trilha createTrilha(TrilhaDTO trilhaDTO);

    Trilha updateTrilha(Long id, TrilhaDTO trilhaDTO);

    void deleteTrilha(Long id);
}
