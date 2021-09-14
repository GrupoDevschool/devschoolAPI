package br.com.devschool.devschool.service.Chamada;

import java.util.List;

import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.formDto.ChamadaFormDTO;

public interface ChamadaService {
    public List<Chamada> ListarChamadas();

    public Chamada inserirChamadas(ChamadaFormDTO chamadaDTO);

    public Chamada alterarChamada(Integer id, ChamadaFormDTO gestoresDTO);

    public void excluirChamada(Integer id);
}
