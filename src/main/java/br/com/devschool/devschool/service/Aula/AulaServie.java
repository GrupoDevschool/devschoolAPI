package br.com.devschool.devschool.service.Aula;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;

import java.util.List;

public interface AulaServie {

    public List<Aula> listarAulas();

    public Aula inserirAula(AulaDTO aulaDTO);

    public Aula alterarAula(Integer id, AulaDTO aulaDTO);

    public void excluirAula(Integer id);
}
