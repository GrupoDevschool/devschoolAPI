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
	
	private String conteudo;
	
	private DisciplinaDTO disciplina;

	private AreaDTO area;
	
	public RespostaDTO(Resposta resposta) {
		this.id = resposta.getId();
		this.conteudo = resposta.getConteudo();
		if (resposta.getDisciplina() != null) {
			this.disciplina = new DisciplinaDTO(resposta.getDisciplina());			
		}else if(resposta.getArea() !=null) {
			this.area = new AreaDTO(resposta.getArea());
		}
	}

	public static List<RespostaDTO> converter(List<Resposta> respostas) {
		return respostas.stream().map(RespostaDTO::new).collect(Collectors.toList());
	}
}
