package br.com.devschool.devschool.service.Turma;

import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.dto.TurmaDTO;
import br.com.devschool.devschool.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public Turma inserirTurma(TurmaDTO turmaDTO) {
        Turma turmas = Turma.builder()
                .numero(turmaDTO.getNumero())
                .alunos(turmaDTO.getAlunoId())
                .gestores(turmaDTO.getGestoresId())
                .build();

        return  turmaRepository.save(turmas);
    }

    @Override
    public Turma alterarTurma(Integer numero, TurmaDTO turmaDTO) {
        Optional<Turma> turmaOptional = turmaRepository.findById(numero);

        if (turmaOptional.isEmpty()) {
            throw new RuntimeException("Turma não encontrado");
        }
        Turma turmas = turmaOptional.get();

        turmas.setNumero(turmaDTO.getNumero());
        turmas.setAlunos(turmaDTO.getAlunoId());
        turmas.setGestores(turmaDTO.getGestoresId());

        return turmaRepository.save(turmas);
    }

    @Override
    public void excluirTurma(Integer numero) {
        Optional<Turma> turmaOptional = turmaRepository.findById(numero);

        if (turmaOptional.isEmpty()) {
            throw new RuntimeException("Turma não existe");
        }
        turmaRepository.deleteAllById(Collections.singleton(numero));
    }
}
