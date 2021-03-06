package br.com.devschool.devschool.model.dto;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.devschool.devschool.model.Gestor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GestorDTO {

	private Integer id;
	@NotBlank
    private String nome;
	@NotBlank
    private String tipo;

    public GestorDTO(Gestor gestor) {
    	this.id = gestor.getId();
        this.nome = gestor.getNome();
        this.tipo = gestor.getTipo();
    }

    public static List<GestorDTO> converter(List<Gestor> gestores) {
        return gestores.stream().map(GestorDTO::new).collect(Collectors.toList());
    }

    public static List<Gestor>converterList(List<GestorDTO> gestores) {
        return gestores.stream().map(Gestor::new).collect(Collectors.toList());
    }
}
