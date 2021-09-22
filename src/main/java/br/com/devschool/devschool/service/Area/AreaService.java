package br.com.devschool.devschool.service.Area;

import java.util.List;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.dto.AreaDTO;

public interface AreaService {
    List<Area> listarAreas();

    Area listarAreaById(Integer id);

    Area inserirArea(AreaDTO areaDTO);

    Area alterarArea(Integer id, AreaDTO areaDTO);

    void excluirArea(Integer id);

}
