package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaFormDTO {
	private String nome;	
	private Integer area;
}
