package br.com.devschool.devschool.service.Chamada;

import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.dto.ChamadaDTO;

import java.util.List;

public interface ChamadaService {
    public List<Chamada> ListarChamadas();

    public Chamada inserirChamadas(ChamadaDTO chamadaDTO);

    public Chamada alterarChamada(Integer id, ChamadaDTO gestoresDTO);

    public void excluirChamada(Integer id);
}
