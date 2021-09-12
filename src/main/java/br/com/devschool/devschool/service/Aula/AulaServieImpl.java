package br.com.devschool.devschool.service.Aula;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.repository.AulaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AulaServieImpl implements AulaServie {

    private AulaRepository aulaRepository;

    @Override
    public List<Aula> listarAulas() {
        List<Aula> aulas = aulaRepository.findAll();

        return aulas;
    }

    @Override
    public Aula inserirAula(AulaDTO aulaDTO) {
      Aula aula = Aula.builder()
              .id(aulaDTO.getId())
              .assunto(aulaDTO.getAssunto())
              .dataHora(aulaDTO.getDataHora())
              .build();

      return  aulaRepository.save(aula);
    }

    @Override
    public Aula alterarAula(Integer id, AulaDTO aulaDTO) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);

        if (aulaOptional.isEmpty()) {
            throw new RuntimeException("Aula inexistente");
        }
        Aula aula = aulaOptional.get();

        aula.setAssunto(aulaDTO.getAssunto());
        aula.setDataHora(aulaDTO.getDataHora());

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
