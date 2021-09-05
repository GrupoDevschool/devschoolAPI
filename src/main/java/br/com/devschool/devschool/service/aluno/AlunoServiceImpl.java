package br.com.devschool.devschool.service.aluno;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.AlunoDTO;
import br.com.devschool.devschool.repository.AlunoRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoServiceImpl implements AlunoService {


    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Override
    public Aluno inserirAluno(AlunoDTO alunoDTO) {
        Aluno aluno = Aluno.builder()
                .matricula(alunoDTO.getMatricula())
                .nome(alunoDTO.getNome())
                .email(alunoDTO.getEmail())
                .observacao(alunoDTO.getObservacao())
                .telefone(alunoDTO.getTelefone())
                .build();

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno alterarAluno(Integer matricula, AlunoDTO alunoDTO) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);

        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }

        Aluno aluno = alunoOptional.get();

        aluno.setNome(aluno.getNome());

        return alunoRepository.save(aluno);
    }

    @Override
    public void excluirAluno(Integer matricula) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);

        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }
        alunoRepository.deleteByMatricula(matricula);
    }
}
