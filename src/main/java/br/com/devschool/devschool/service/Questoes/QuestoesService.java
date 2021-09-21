package br.com.devschool.devschool.service.Questoes;

import java.util.List;

import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.formDto.QuestaoFormDto;

public interface QuestoesService {
    List<Questoes> listarQuestoes(Integer avaliacaoId);

    Questoes listarQuestoesById(Integer id);


    Questoes inserirQuestoes(QuestaoFormDto questoesDTO);

    Questoes alterarQuestoes(Integer id, QuestaoFormDto questoesDTO);

    void excluirQuestao(Integer id);


}
