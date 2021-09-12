package br.com.devschool.devschool.service.Area;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.model.dto.AulaDTO;

import java.util.List;

public interface AreaService {
    public List<Area> listarAreas();

    public Area inserirArea(AreaDTO areaDTO);

    public Area alterarArea(Integer id, AreaDTO areaDTO);

    public void excluirArea(Integer id);

}
