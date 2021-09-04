package br.com.devschool.devschool.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Disciplina;
import lombok.Data;

@Data
public class DisciplinaDTO {
	
	private Integer id;
	
	private String nome;

	public DisciplinaDTO(Disciplina disciplina) {
		this.id = disciplina.getId();
		this.nome = disciplina.getNome();
	}
	
	public static List<DisciplinaDTO>converter(List<Disciplina> disciplinas) {
		return disciplinas.stream().map(DisciplinaDTO::new).collect(Collectors.toList());
	}
}
