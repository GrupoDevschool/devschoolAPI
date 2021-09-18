package br.com.devschool.devschool.service.Aula;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;
import br.com.devschool.devschool.repository.AulaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AulaServiceImpl implements AulaService {

    private AulaRepository aulaRepository;

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
        return aulaRepository.findById(id).get();
    }


    @Override
    public Aula inserirAula(AulaFormDTO aulaDTO) {
      Aula aula = Aula.builder()
              .id(aulaDTO.getId())
              .assunto(aulaDTO.getAssunto())
              .dataHora(aulaDTO.getDataHora())
              .gestores(Gestor.converter(aulaDTO.getGestores()))
              .build();

      return  aulaRepository.save(aula);
    }

    @Override
    public Aula alterarAula(Integer id, AulaFormDTO aulaDTO) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);

        if (aulaOptional.isEmpty()) {
            throw new RuntimeException("Aula inexistente");
        }
        Aula aula = aulaOptional.get();

        aula.setAssunto(aulaDTO.getAssunto());
        aula.setDataHora(aulaDTO.getDataHora());
        aula.setGestores(Gestor.converter(aulaDTO.getGestores()));
        
        return  aulaRepository.save(aula);
    }

    @Override
    public void excluirAula(Integer id) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);

        if (aulaOptional.isEmpty()) {
            throw new RuntimeException("Aula não existe");
        }
        aulaRepository.deleteById(id);
    }
}
