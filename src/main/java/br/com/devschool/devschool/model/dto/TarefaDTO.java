package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

	private Integer id;
	
	private String data;
	
	private String descricao;

	private GrupoDTO grupo;

    public TarefaDTO(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.data = tarefa.getData();
		this.descricao = tarefa.getDescricao();
		this.grupo = new GrupoDTO(tarefa.getGrupo());
	}

	public static List<TarefaDTO>converter(List<Tarefa> tarefa) {
		return tarefa.stream().map(TarefaDTO::new).collect(Collectors.toList());
	}
}
