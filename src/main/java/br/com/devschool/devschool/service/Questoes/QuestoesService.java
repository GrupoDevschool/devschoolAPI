package br.com.devschool.devschool.service.Questoes;

import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.dto.QuestoesDTO;

import java.util.List;

public interface QuestoesService {
    List<Questoes> listarQuestoes(Integer avaliacaoId);

    Questoes listarQuestoesById(Integer id);


    Questoes inserirQuestoes(QuestoesDTO questoesDTO);

    Questoes alterarQuestoes(Integer id, QuestoesDTO questoesDTO);

    void excluirQuestao(Integer id);


}
