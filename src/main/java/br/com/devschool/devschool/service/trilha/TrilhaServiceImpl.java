package br.com.devschool.devschool.service.trilha;

import br.com.devschool.devschool.dto.TrilhaDTO;
import br.com.devschool.devschool.model.Trilha;
import br.com.devschool.devschool.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrilhaServiceImpl implements TrilhaService{

    private TrilhaRepository trilhaRepository;

    @Autowired
    public TrilhaServiceImpl(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    @Override
    public List<Trilha> getAllTrilha() {
        return null;
    }

    @Override
    public Trilha getTrilhaById(Long id) {
        return null;
    }

    @Override
    public Trilha createTrilha(TrilhaDTO trilhaDTO) {
        return null;
    }

    @Override
    public Trilha updateTrilha(Long id, TrilhaDTO trilhaDTO) {
        return null;
    }

    @Override
    public void deleteTrilha(Long id) {

    }
}
