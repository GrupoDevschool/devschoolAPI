package br.com.devschool.devschool.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Avaliacao;
import lombok.Data;

@Data
public class AvaliacaoDTO {

	private Integer id;
	
	private LocalDate data;
	
	private String descricao;

    public AvaliacaoDTO(Avaliacao avaliacao) {
		this.id = avaliacao.getId();
		this.data = avaliacao.getData();
		this.descricao = avaliacao.getDescricao();
	}
	
	public static List<AvaliacaoDTO>converter(List<Avaliacao> avaliacao) {
		return avaliacao.stream().map(AvaliacaoDTO::new).collect(Collectors.toList());
	}
}
