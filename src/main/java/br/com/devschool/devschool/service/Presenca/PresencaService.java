package br.com.devschool.devschool.service.Presenca;

import java.util.List;

import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;

public interface PresencaService {
    List<Presenca> ListarChamadas();

    Presenca listarChamadaById(Integer id);


    Presenca inserirChamadas(PresencaFormDTO chamadaDTO);

    Presenca alterarChamada(Integer id, PresencaFormDTO gestoresDTO);

    void excluirChamada(Integer id);
}
