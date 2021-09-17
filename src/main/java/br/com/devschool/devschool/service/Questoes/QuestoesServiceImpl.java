package br.com.devschool.devschool.service.Questoes;


import br.com.devschool.devschool.model.*;
import br.com.devschool.devschool.model.dto.QuestoesDTO;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;
import br.com.devschool.devschool.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class QuestoesServiceImpl implements QuestoesService {

    public QuestoesRepository questoesRepository;

    @Override
    public List<Questoes> listarQuestoes() {
        List<Questoes> questoes = questoesRepository.findAll();

        return questoes;
    }

    @Override
    public Questoes listarQuestoesById(Integer id) {
        return questoesRepository.findById(id).get();
    }

    @Override
    public Questoes inserirQuestoes(QuestoesDTO questoesDTO) {
        Questoes questoes = Questoes.builder()
                .id(questoesDTO.getId())
                .ordem(questoesDTO.getOrdem())
               // .pergunta(questoesDTO.getPergunta())
                .build();

        return  questoesRepository.save(questoes);
    }

    @Override
    public Questoes alterarQuestoes(Integer id, QuestoesDTO questoesDTO) {
        Optional<Questoes> questoesOptional = questoesRepository.findById(id);

        if (questoesOptional.isEmpty()) {
            throw new RuntimeException("Questao não encontrada");
        }
        Questoes questoes = questoesOptional.get();

        questoes.setId(questoesDTO.getId());
        questoes.setOrdem(questoes.getOrdem());
       // questoes.setPergunta(questoesDTO.getPergunta());

        return  questoesRepository.save(questoes);
    }

    @Override
    public void excluirQuestao(Integer id) {
        Optional<Questoes> questoesOptional = questoesRepository.findById(id);

        if (questoesOptional.isEmpty()) {
            throw new RuntimeException("Questao não existe");
        }
        questoesRepository.deleteById(id);

    }
}
