package br.com.devschool.devschool.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Avaliacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {

	private Integer id;
	
	private String data;
	
	private String descricao;

	private GestorDTO gestor;

    public AvaliacaoDTO(Avaliacao avaliacao) {
		this.id = avaliacao.getId();
		this.data = avaliacao.getData();
		this.descricao = avaliacao.getDescricao();
		this.gestor = new GestorDTO(avaliacao.getGestor());
	}

	public static List<AvaliacaoDTO>converter(List<Avaliacao> avaliacao) {
		return avaliacao.stream().map(AvaliacaoDTO::new).collect(Collectors.toList());
	}
}
