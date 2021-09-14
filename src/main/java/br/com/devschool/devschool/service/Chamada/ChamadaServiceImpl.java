package br.com.devschool.devschool.service.Chamada;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.formDto.ChamadaFormDTO;
import br.com.devschool.devschool.repository.AlunoRepository;
import br.com.devschool.devschool.repository.AulaRepository;
import br.com.devschool.devschool.repository.ChamadaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChamadaServiceImpl  implements ChamadaService{
    private final ChamadaRepository chamadaRepository;
    private final AlunoRepository alunoRepository;
    private final AulaRepository aulaRepository;


    @Override
    public List<Chamada> ListarChamadas() {
        List<Chamada> chamadas = chamadaRepository.findAll();
        return chamadas;
    }

    @Override
    public Chamada inserirChamadas(ChamadaFormDTO chamadaDTO) {
    	Optional<Aluno> alunoOptional = alunoRepository.findById(chamadaDTO.getAlunoId());
    	if (alunoOptional.isEmpty()) {
    		throw new RuntimeException("Aluno inexistente");
    	}
    	Aluno aluno = alunoOptional.get();
    	
    	Optional<Aula> aulaOptional = aulaRepository.findById(chamadaDTO.getAulaId());
    	if (aulaOptional.isEmpty()) {
    		throw new RuntimeException("Aula inexistente");
    	}
    	Aula aula = aulaOptional.get();
    	
    	Chamada chamadas = Chamada.builder()
                .id(chamadaDTO.getId())
                .aluno(aluno)
                .aula(aula)
                .horaEntrada(chamadaDTO.getHoraEntrada())
                .build();

        return  chamadaRepository.save(chamadas);
    }

    @Override
    public Chamada alterarChamada(Integer id, ChamadaFormDTO chamadaDTO) {
        Optional<Chamada> chamadaOptional = chamadaRepository.findById(id);
        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("não encontrado");
        }
        Chamada chamadas = chamadaOptional.get();
        
        Optional<Aluno> alunoOptional = alunoRepository.findById(chamadaDTO.getAlunoId());
    	if (alunoOptional.isEmpty()) {
    		throw new RuntimeException("Aluno inexistente");
    	}
    	Aluno aluno = alunoOptional.get();
    	
    	Optional<Aula> aulaOptional = aulaRepository.findById(chamadaDTO.getAulaId());
    	if (aulaOptional.isEmpty()) {
    		throw new RuntimeException("Aula inexistente");
    	}
    	Aula aula = aulaOptional.get();

        chamadas.setAluno(aluno);
        chamadas.setHoraEntrada(chamadaDTO.getHoraEntrada());
        chamadas.setAula(aula);

        return  chamadaRepository.save(chamadas);
    }

    @Override
    public void excluirChamada(Integer id) {
        Optional<Chamada> chamadaOptional = chamadaRepository.findById(id);

        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }
        chamadaRepository.deleteById(id);

    }
}
