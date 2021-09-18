package br.com.devschool.devschool.service.Aula;

import java.util.List;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;

public interface AulaService {

    List<Aula> listarAulas(String dataHora , Integer turmaId);

    Aula listarAulaById(Integer id);


    Aula inserirAula(AulaFormDTO aulaDTO);

    Aula alterarAula(Integer id, AulaFormDTO aulaDTO);

    void excluirAula(Integer id);
}
