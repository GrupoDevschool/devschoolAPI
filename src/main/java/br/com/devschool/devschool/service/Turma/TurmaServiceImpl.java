package br.com.devschool.devschool.service.Turma;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.formDto.TurmaFormDTO;
import br.com.devschool.devschool.repository.TurmaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TurmaServiceImpl implements TurmaService{

    public TurmaRepository turmaRepository;

    @Override
    public List<Turma> listarTurmas() {
        List<Turma> turmas = turmaRepository.findAll();

        return turmas;
    }

    @Override
    public Turma listarTurmaByNome(String nome) {
        return turmaRepository.findByNome(nome)
                .orElseThrow(() -> new ContentNotFoundException("A turma com nome " + nome + " não foi encontrada."));
    }


    @Override
    public Turma inserirTurma(TurmaFormDTO turmaDTO) {
        Turma turma = Turma.builder()
                .nome(turmaDTO.getNome())
                .build();

        return  turmaRepository.save(turma);
    }

    @Override
    public Turma alterarTurma(Integer id, TurmaFormDTO turmaDTO) {
        Turma turma = this.buscarTurmaPorId(id);

        turma.setNome(turmaDTO.getNome());

        return turmaRepository.save(turma);
    }

    @Override
    public void excluirTurma(Integer id) {
    	this.buscarTurmaPorId(id);
        turmaRepository.deleteById(id);
    }
    
    public Turma buscarTurmaPorId(Integer id) {
    	return turmaRepository.findById(id)
    			.orElseThrow(() -> new ContentNotFoundException("Não foi possivel encontrar a turma com id " + id));
    }
}
