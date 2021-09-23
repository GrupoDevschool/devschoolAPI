package br.com.devschool.devschool.service.Presenca;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;
import br.com.devschool.devschool.repository.PresencaRepository;
import br.com.devschool.devschool.service.Aluno.AlunoService;
import br.com.devschool.devschool.service.Aula.AulaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PresencaServiceImpl implements PresencaService {
    private final PresencaRepository presencaRepository;
    private final AulaService aulaService;
    private final AlunoService alunoService;


    @Override
    public List<Presenca> ListarChamadas() {
        return presencaRepository.findAll();
    }

    @Override
    public Presenca listarChamadaById(Integer id) {
        return presencaRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Chamada do : " + id + " não foi encontrada."));
    }

    @Override
    public List<Presenca> listarChamadaByAula(Integer aulaId) {
        return presencaRepository.findAllByAulaId(aulaId);
    }



    @Override
    public Presenca inserirChamadas(PresencaFormDTO presencaFormDTO) {
        Aluno aluno = alunoService.listarAlunoByMatricula(presencaFormDTO.getAlunoId());
        Aula aula = aulaService.listarAulaById(presencaFormDTO.getAulaId());

        Presenca presenca = Presenca.builder()
                .aluno(aluno)
                .aula(aula)
                .horaEntrada(presencaFormDTO.getHoraEntrada())
                .build();

        return presencaRepository.save(presenca);
        }

    @Override
    public Presenca alterarChamada(Integer id, PresencaFormDTO presencaFormDTO) {
        Presenca presenca = presencaRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Chamada do : " + id + " não foi encontrada."));
        Aluno aluno = alunoService.listarAlunoByMatricula(presencaFormDTO.getAlunoId());
        Aula aula = aulaService.listarAulaById(presencaFormDTO.getAulaId());

        presenca.setAluno(aluno);
        presenca.setAula(aula);
        presenca.setHoraEntrada(presencaFormDTO.getHoraEntrada());

        return  presencaRepository.save(presenca);
    }

    @Override
    public void excluirChamada(Integer id) {
       this.listarChamadaById(id);
       presencaRepository.deleteById(id);
    }

}
