package br.com.devschool.devschool.service.trilha;

import br.com.devschool.devschool.model.dto.TrilhaDTO;
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
        return trilhaRepository.findAll();
    }

    @Override
    public Trilha getTrilhaById(Long id) {
        return trilhaRepository.findById(id).get();
    }

    @Override
    public Trilha createTrilha(TrilhaDTO trilhaDTO) {
        Trilha trilha = Trilha.builder()
                .nome(trilhaDTO.getNome())
                .disciplinasRegistradas(trilhaDTO.getDisciplinas())
                .build();
        return trilhaRepository.save(trilha);
    }

    @Override
    public Trilha updateTrilha(Long id, TrilhaDTO trilhaDTO) {
        Trilha trilha = trilhaRepository.findById(id).get();

        trilha.setNome(trilhaDTO.getNome());
        trilha.setDisciplinasRegistradas(trilhaDTO.getDisciplinas());

        return trilhaRepository.save(trilha);
    }

    @Override
    public void deleteTrilha(Long id) {
        trilhaRepository.deleteById(id);
    }
}
