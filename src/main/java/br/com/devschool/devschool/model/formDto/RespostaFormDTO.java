package br.com.devschool.devschool.model.formDto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaFormDTO {
	
	@NotNull
	private String conteudo;
	@NotNull
	private Integer disciplinaId;
}
