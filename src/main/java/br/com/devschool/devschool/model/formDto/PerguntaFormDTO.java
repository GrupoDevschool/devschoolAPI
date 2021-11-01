package br.com.devschool.devschool.model.formDto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerguntaFormDTO {
	
	@NotBlank
	private String enunciado;
	@NotNull
	private Integer respostaCorreta;
	@NotEmpty
	private List<Integer> respostas;
	@NotNull
	private Integer disciplina;
	
}
