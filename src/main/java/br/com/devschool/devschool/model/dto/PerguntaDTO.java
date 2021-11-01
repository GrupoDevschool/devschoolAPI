package br.com.devschool.devschool.model.dto;


import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Pergunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerguntaDTO {
	
	private Integer id;	
	private String enunciado;
	private RespostaDTO respostaCorreta;
	private List<RespostaDTO> respostas;
	private DisciplinaDTO disciplina;
	
	public PerguntaDTO(Pergunta pergunta) {
		this.id = pergunta.getId();
		this.enunciado = pergunta.getEnunciado();
		if (pergunta.getDisciplina() != null)
			this.disciplina = new DisciplinaDTO(pergunta.getDisciplina());			
		if (pergunta.getRespostas() != null)
			this.respostas = RespostaDTO.converter(pergunta.getRespostas());
		if (pergunta.getResponstaCorreta() != null)
			this.respostaCorreta = new RespostaDTO(pergunta.getResponstaCorreta());
	}

	public static List<PerguntaDTO> converter(List<Pergunta> perguntas) {
		return perguntas.stream().map(PerguntaDTO::new).collect(Collectors.toList());
	}
}
