package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AulaGestorFormDTO {
	@NotNull
	private Integer gestorId;

	@NotNull
	private Integer aulaId;
	
}
