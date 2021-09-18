package br.com.devschool.devschool.service.Aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.formDto.AlunoFormDTO;
import br.com.devschool.devschool.repository.AlunoRepository;
import br.com.devschool.devschool.repository.TurmaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoServiceImpl implements AlunoService {


    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    @Override
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Override
    public Aluno listarAlunoByMatricula(Integer matricula){
        return alunoRepository.findByMatricula(matricula).get();
    }


    @Override
    public List<Aluno> listarAlunosByTurmaId(Integer turmaId) {
       if(turmaId != null){
           return alunoRepository.findAllByTurma_Id(turmaId);
       }
       return alunoRepository.findAll();
    }


    @Override
    public Aluno inserirAluno(AlunoFormDTO alunoDTO) {
    	Turma turma = null;
    	if (alunoDTO.getTurmaId() != null) {
    		Optional<Turma> turmaOptional = turmaRepository.findById(alunoDTO.getTurmaId());
    		if (turmaOptional.isEmpty()) {
    			throw new RuntimeException("Turma inexistente");
    		}
    		turma = turmaOptional.get();    		
    	}
    	
    	Aluno aluno = Aluno.builder()
                .matricula(alunoDTO.getMatricula())
                .nome(alunoDTO.getNome())
                .email(alunoDTO.getEmail())
                .observacao(alunoDTO.getObservacao())
                .telefone(alunoDTO.getTelefone())
                .turma(turma)
                .build();

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno alterarAluno(Integer matricula, AlunoFormDTO alunoDTO) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);

        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }

        Aluno aluno = alunoOptional.get();

        Optional<Turma> turmaOptional = turmaRepository.findById(alunoDTO.getTurmaId());
        if (turmaOptional.isEmpty()) {
        	throw new RuntimeException("Turma inexistente");
        }
        Turma turma = turmaOptional.get();
        
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setObservacao(alunoDTO.getObservacao());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setTurma(turma);

        return alunoRepository.save(aluno);
    }

    @Override
    public void excluirAluno(Integer matricula) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);

        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }
        alunoRepository.deleteById(matricula);
    }
}
