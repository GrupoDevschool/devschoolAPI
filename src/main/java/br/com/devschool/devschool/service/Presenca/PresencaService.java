package br.com.devschool.devschool.service.Presenca;

import java.util.List;

import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;

public interface PresencaService {
    public List<Presenca> ListarChamadas();

    public Presenca inserirChamadas(PresencaFormDTO chamadaDTO);

    public Presenca alterarChamada(Integer id, PresencaFormDTO gestoresDTO);

    public void excluirChamada(Integer id);
}
