package br.com.devschool.devschool.service.Area;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.model.dto.AulaDTO;

import java.util.List;

public interface AreaService {
    List<Area> listarAreas();

    Area listarAreaById(Integer id);

    Area inserirArea(AreaDTO areaDTO);

    Area alterarArea(Integer id, AreaDTO areaDTO);

    void excluirArea(Integer id);

}
