package br.com.devschool.devschool.model.formDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFormDTO {
	
	@NotBlank
	private String data;
	@NotBlank
	private String descricao;
	@NotNull
	private Integer gestorId;
	
}
