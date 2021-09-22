package br.com.devschool.devschool.model.formDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaFormDTO {
	
	@NotBlank
	private String nome;
	@NotNull
	private Integer area;
	
}
