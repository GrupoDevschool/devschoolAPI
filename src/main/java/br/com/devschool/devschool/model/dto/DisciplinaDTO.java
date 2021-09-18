package br.com.devschool.devschool.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO {
	
	private Integer id;
	
	private String nome;
	
	private AreaDTO area;

	public DisciplinaDTO(Disciplina disciplina) {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
		this.area = new AreaDTO(disciplina.getArea());
	}

	public static List<DisciplinaDTO>converter(List<Disciplina> disciplinas) {
		return disciplinas.stream().map(DisciplinaDTO::new).collect(Collectors.toList());
	}

	public static List<Disciplina>converterList(List<DisciplinaDTO> disciplinas) {
		return disciplinas.stream().map(Disciplina::new).collect(Collectors.toList());
	}
}
