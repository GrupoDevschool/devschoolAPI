package br.com.devschool.devschool.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.devschool.devschool.model.dto.AreaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    
    @ManyToMany(mappedBy = "areas")
    private List<Disciplina> disciplinas;

    public Area(AreaDTO areaDTO) {
        this.id = areaDTO.getId();
        this.descricao = areaDTO.getDescricao();

    }
    
    public static List<Area> converter(List<AreaDTO> areas) {
    	return areas.stream().map(Area::new).collect(Collectors.toList());
	}
}
