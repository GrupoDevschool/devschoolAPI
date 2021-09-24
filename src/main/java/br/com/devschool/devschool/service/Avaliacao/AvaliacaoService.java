package br.com.devschool.devschool.service.Avaliacao;

import java.util.List;

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.formDto.AvaliacaoFormDTO;

public interface AvaliacaoService {
	
	List<Avaliacao> listarAvaliacoes(Integer gestorId);

	Avaliacao listarAvaliacoesById(Integer id);
	
	Avaliacao inserirAvaliacao(AvaliacaoFormDTO avaliacaoDTO);
	
	Avaliacao alterarAvaliacao(Integer id, AvaliacaoFormDTO avaliacaoDTO);
	
	void excluirAvaliacao(Integer id);

}
