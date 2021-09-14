package br.com.devschool.devschool.model.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Resposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {
	
	private Integer id;
	
	private String descricao;
	
	private DisciplinaDTO disciplina;
	
	public RespostaDTO(Resposta resposta) {
		this.id = resposta.getId();
		this.descricao = resposta.getDescricao();
		if (resposta.getDisciplina() != null) {
			this.disciplina = new DisciplinaDTO(resposta.getDisciplina());			
		}
	}

	public static List<RespostaDTO> converter(List<Resposta> respostas) {
		return respostas.stream().map(RespostaDTO::new).collect(Collectors.toList());
	}
}
