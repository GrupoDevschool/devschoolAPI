package br.com.devschool.devschool.model.formDto;

import java.util.List;

import br.com.devschool.devschool.model.dto.RespostaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerguntaFormDTO {
	
	private String enunciado;
	private Integer respostaCorreta;
	private List<RespostaDTO> respostas;
	private Integer disciplina;
}
