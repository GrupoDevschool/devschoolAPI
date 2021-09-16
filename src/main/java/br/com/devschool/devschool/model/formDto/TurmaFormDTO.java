package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaFormDTO {
	private Integer id;
	private String nome;
}
