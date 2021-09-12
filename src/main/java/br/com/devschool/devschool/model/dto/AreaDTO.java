package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {

    private Integer id;

    private String descricao;


    public AreaDTO(Area area) {
        this.id = area.getId();
        this.descricao = area.getDescricao();
    }

    public static List<AreaDTO> converter(List<Area> areas) {
        return areas.stream().map(AreaDTO::new).collect(Collectors.toList());
    }

    public static List<Area>converterList(List<AreaDTO> areas) {
        return areas.stream().map(Area::new).collect(Collectors.toList());
    }
}
