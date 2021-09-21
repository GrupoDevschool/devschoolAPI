package br.com.devschool.devschool.model.formDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class QuestaoFormDto {

	private Integer id_avaliacao;
	private Integer numero;
	private List<Integer> perguntaResposta;
	
}
