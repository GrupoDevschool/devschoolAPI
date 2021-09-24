package br.com.devschool.devschool.service.Aula;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;
import br.com.devschool.devschool.repository.AulaRepository;
import br.com.devschool.devschool.service.Turma.TurmaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AulaServiceImpl implements AulaService {

    private AulaRepository aulaRepository;
    private TurmaService turmaService;
    
    @Override
    public List<Aula> listarAulas(String datahora , Integer turmaId) {
       if(datahora != null  && !datahora.isEmpty()){
            return aulaRepository.findByDataHora(datahora);
       }else if(turmaId != null){
            return aulaRepository.findByTurma_Id(turmaId);
        }else {
           return aulaRepository.findAll();
       }

    }

    @Override
    public Aula listarAulaById(Integer id) {
        return aulaRepository.findById(id)
                .orElseThrow(() -> new ContentNotFoundException("Aula com id "+ id + " não foi encontrada"));
    }


    @Override
    public Aula inserirAula(AulaFormDTO aulaDTO) {
      Turma turma = turmaService.buscarTurmaPorId(aulaDTO.getTurmaId());

      Aula aula = Aula.builder()
              .assunto(aulaDTO.getAssunto())
              .dataHora(aulaDTO.getDataHora())
              .gestores(Gestor.converter(aulaDTO.getGestores()))
              .turma(turma)
              .build();

      return  aulaRepository.save(aula);
    }

    @Override
    public Aula alterarAula(Integer id, AulaFormDTO aulaDTO) {
        Aula aula = this.listarAulaById(id);
        Turma turma = turmaService.buscarTurmaPorId(aulaDTO.getTurmaId());

        aula.setAssunto(aulaDTO.getAssunto());
        aula.setDataHora(aulaDTO.getDataHora());
        aula.setGestores(Gestor.converter(aulaDTO.getGestores()));
        aula.setTurma(turma);
        
        return  aulaRepository.save(aula);
    }

    @Override
    public void excluirAula(Integer id) {
        this.listarAulaById(id);
        aulaRepository.deleteById(id);
    }
}
