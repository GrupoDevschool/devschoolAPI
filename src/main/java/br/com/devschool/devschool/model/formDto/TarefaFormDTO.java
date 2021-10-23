package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaFormDTO {
	
	@NotBlank
	private String data;
	@NotBlank
	private String descricao;
	@NotNull
	private Integer grupoId;
	
}
