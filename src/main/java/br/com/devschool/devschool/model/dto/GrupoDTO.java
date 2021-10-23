package br.com.devschool.devschool.model.dto;


import br.com.devschool.devschool.model.Grupo;
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
public class GrupoDTO {
	
    private Integer id;

    private String nome;

    public GrupoDTO(Grupo grupo) {
        this.id = grupo.getId();
        this.nome = grupo.getNome();
    }

    public static List<GrupoDTO> converter(List<Grupo> grupos) {
    	if (grupos == null) return null;
        return grupos.stream().map(GrupoDTO::new).collect(Collectors.toList());
    }

    public static List<Grupo> convertList(List<GrupoDTO> grupos){
    	if (grupos == null) return null;
        return grupos.stream().map(Grupo::new).collect(Collectors.toList());

    }
}
