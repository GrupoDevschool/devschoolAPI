package br.com.devschool.devschool.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.AulaGestor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AulaGestorDTO {

	private AulaDTO aula;
	private GestorDTO gestor;
	
	public AulaGestorDTO(AulaGestor aulaGestor) {
		this.aula = new AulaDTO(aulaGestor.getAula());
		this.gestor = new GestorDTO(aulaGestor.getGestor());
	}

	public static List<AulaGestorDTO> converter(List<AulaGestor> aulasGestores) {
		return aulasGestores.stream().map(AulaGestorDTO::new).collect(Collectors.toList());
	}
}
