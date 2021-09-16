package br.com.devschool.devschool.service.Presenca;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;
import br.com.devschool.devschool.repository.AlunoRepository;
import br.com.devschool.devschool.repository.AulaRepository;
import br.com.devschool.devschool.repository.PresencaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PresencaServiceImpl implements PresencaService {
    private final PresencaRepository presencaRepository;
    private final AlunoRepository alunoRepository;
    private final AulaRepository aulaRepository;


    @Override
    public List<Presenca> ListarChamadas() {
        List<Presenca> presencas = presencaRepository.findAll();
        return presencas;
    }

    @Override
    public Presenca listarChamadaById(Integer id) {
        return presencaRepository.findById(id).get();
    }

    @Override
    public Presenca inserirChamadas(PresencaFormDTO presencaFormDTO) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(presencaFormDTO.getAlunoId());
        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno inexistente");
            }
            Aluno aluno = alunoOptional.get();

              Optional<Aula> aulaOptional = aulaRepository.findById(presencaFormDTO.getAulaId());
            if (aulaOptional.isEmpty()) {
                throw new RuntimeException("Aula inexistente");
            }
            Aula aula = aulaOptional.get();

            Presenca presenca = Presenca.builder()
                    .id(presencaFormDTO.getId())
                    .aluno(aluno)
                    .aula(aula)
                    .horaEntrada(presencaFormDTO.getHoraEntrada())
                    .build();

            return presencaRepository.save(presenca);
        }

    @Override
    public Presenca alterarChamada(Integer id, PresencaFormDTO presencaFormDTO) {
        Optional<Presenca> chamadaOptional = presencaRepository.findById(id);
        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("não encontrado");
        }
        Presenca presenca = chamadaOptional.get();
        
        Optional<Aluno> alunoOptional = alunoRepository.findById(presencaFormDTO.getAlunoId());
    	if (alunoOptional.isEmpty()) {
    		throw new RuntimeException("Aluno inexistente");
    	}
    	Aluno aluno = alunoOptional.get();
    	
    	Optional<Aula> aulaOptional = aulaRepository.findById(presencaFormDTO.getAulaId());
    	if (aulaOptional.isEmpty()) {
    		throw new RuntimeException("Aula inexistente");
    	}
    	Aula aula = aulaOptional.get();

        presenca.setAluno(aluno);
        presenca.setHoraEntrada(presencaFormDTO.getHoraEntrada());
        presenca.setAula(aula);

        return  presencaRepository.save(presenca);
    }

    @Override
    public void excluirChamada(Integer id) {
        Optional<Presenca> chamadaOptional = presencaRepository.findById(id);

        if (chamadaOptional.isEmpty()) {
            throw new RuntimeException("Aluno não existe");
        }
        presencaRepository.deleteById(id);

    }
}
