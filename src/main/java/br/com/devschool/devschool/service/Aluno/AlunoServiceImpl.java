package br.com.devschool.devschool.service.Aluno;

import java.util.List;
import java.util.Optional;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Resposta;
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
        return alunoRepository.findAll();
    }

    @Override
    public Aluno listarAlunoByMatricula(Integer matricula) throws RuntimeException{
        return alunoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new ContentNotFoundException("Aluno com a matricula: " + matricula + " não foi encontrada."));
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

        Aluno aluno = alunoRepository.findById(matricula)
                .orElseThrow(() -> new ContentNotFoundException("Aluno com id "+ matricula +" não foi encontrada"));


        Turma turma = turmaRepository.findById(alunoDTO.getTurmaId())
                .orElseThrow(() -> new ContentNotFoundException("Turma com id "+ alunoDTO.getTurmaId() +" não foi encontrada"));


        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setObservacao(alunoDTO.getObservacao());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setTurma(turma);

        return alunoRepository.save(aluno);
    }

    @Override
    public void excluirAluno(Integer matricula) {
        this.listarAlunoByMatricula(matricula);
        alunoRepository.deleteById(matricula);
    }
}
