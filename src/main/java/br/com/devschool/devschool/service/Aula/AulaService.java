package br.com.devschool.devschool.service.Aula;

import java.util.List;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;

public interface AulaService {

    public List<Aula> listarAulas();

    public Aula inserirAula(AulaFormDTO aulaDTO);

    public Aula alterarAula(Integer id, AulaFormDTO aulaDTO);

    public void excluirAula(Integer id);
}
