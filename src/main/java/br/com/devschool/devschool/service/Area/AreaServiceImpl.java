package br.com.devschool.devschool.service.Area;


import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.repository.AreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Area> areaOptional = areaRepository.findById(id);

        if (areaOptional.isEmpty()) {
            throw new RuntimeException("Area inexistente");
        }
        return areaRepository.findAreaById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Area inserirArea(AreaDTO areaDTO) {
        Area area = Area.builder()
                .id(areaDTO.getId())
                .descricao(areaDTO.getDescricao())
                .build();

        return  areaRepository.save(area);
    }

    @Override
    public Area alterarArea(Integer id, AreaDTO areaDTO) {
        Optional<Area> areaOptional = areaRepository.findById(id);

        if (areaOptional.isEmpty()) {
            throw new RuntimeException("Area inexistente");
        }
        Area area = areaOptional.get();

        area.setDescricao(areaDTO.getDescricao());

        return  areaRepository.save(area);
    }

    @Override
    public void excluirArea(Integer id) {
        Optional<Area> areaOptional = areaRepository.findById(id);

        if (areaOptional.isEmpty()) {
            throw new RuntimeException("Area não existe");
        }
        areaRepository.deleteById(id);
    }
}
