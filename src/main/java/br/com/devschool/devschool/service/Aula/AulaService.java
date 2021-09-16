package br.com.devschool.devschool.service.Aula;

import java.util.List;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;

public interface AulaService {

    List<Aula> listarAulas();

    Aula listarAulaById(Integer id);

    Aula listarAulaByDate(String dataHora);


    Aula inserirAula(AulaFormDTO aulaDTO);

    Aula alterarAula(Integer id, AulaFormDTO aulaDTO);

    void excluirAula(Integer id);
}
