package br.com.devschool.devschool.service.Trilha;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.model.dto.TrilhaDTO;
import br.com.devschool.devschool.model.Trilha;
import br.com.devschool.devschool.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Trilha com o : " + id + " não foi encontrada."));
    }

    @Override
    public Trilha createTrilha(TrilhaDTO trilhaDTO) {
        Trilha trilha = Trilha.builder()
                .nome(trilhaDTO.getNome())
                .disciplinasRegistradas(DisciplinaDTO.converterList(trilhaDTO.getDisciplinas()))
                .build();
        return trilhaRepository.save(trilha);
    }

    @Override
    public Trilha updateTrilha(Long id, TrilhaDTO trilhaDTO) {
        Trilha trilha = trilhaRepository.findById(id).get();

        trilha.setNome(trilhaDTO.getNome());
        trilha.setDisciplinasRegistradas(DisciplinaDTO.converterList(trilhaDTO.getDisciplinas()));

        return trilhaRepository.save(trilha);
    }

    @Override
    public void deleteTrilha(Long id) {
        this.getTrilhaById(id);
        trilhaRepository.deleteById(id);
    }
}
