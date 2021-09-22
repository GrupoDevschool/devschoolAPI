package br.com.devschool.devschool.model.formDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class QuestaoFormDto {

	@NotNull
	private Integer id_avaliacao;

	@NotNull
	private Integer numero;

	@NotEmpty
	private List<Integer> perguntaResposta;
	
}
