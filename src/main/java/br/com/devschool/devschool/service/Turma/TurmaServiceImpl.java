package br.com.devschool.devschool.service.Turma;

import java.util.List;
import java.util.Optional;

import br.com.devschool.devschool.model.Disciplina;
import org.springframework.stereotype.Service;

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
        return turmaRepository.findByNome(nome).get();
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
        Optional<Turma> turmaOptional = turmaRepository.findById(id);

        if (turmaOptional.isEmpty()) {
            throw new RuntimeException("Turma não encontrado");
        }
        Turma turma = turmaOptional.get();

        turma.setNome(turmaDTO.getNome());

        return turmaRepository.save(turma);
    }

    @Override
    public void excluirTurma(Integer id) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);

        if (turmaOptional.isEmpty()) {
            throw new RuntimeException("Turma não existe");
        }
        turmaRepository.deleteById(id);
    }
}
