package br.com.devschool.devschool.service.Area;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.repository.AreaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AreaServiceImpl  implements  AreaService{
    
	private AreaRepository areaRepository;

    @Override
    public List<Area> listarAreas() {
        List<Area> areas = areaRepository.findAll();
        return areas;
    }

    @Override
    public Area listarAreaById(Integer id) throws  RuntimeException{
        return areaRepository.findById(id)
        		.orElseThrow(() -> new ContentNotFoundException("Area com id " + id + " não encontrada."));
    }

    @Override
    public Area inserirArea(AreaDTO areaDTO) {
        Area area = Area.builder()
                .descricao(areaDTO.getDescricao())
                .build();

        return  areaRepository.save(area);
    }

    @Override
    public Area alterarArea(Integer id, AreaDTO areaDTO) {
    	Area area = this.listarAreaById(id);

        area.setDescricao(areaDTO.getDescricao());

        return areaRepository.save(area);
    }

    @Override
    public void excluirArea(Integer id) {
    	this.listarAreaById(id);
        areaRepository.deleteById(id);
    }
}
