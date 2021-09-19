package br.com.devschool.devschool.service.Avaliacao;

import java.util.List;

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;

public interface AvaliacaoService {
	
	List<Avaliacao> listarAvaliacoes(Integer gestorId);

	Avaliacao listarAvaliacoesById(Integer id);
	
	Avaliacao inserirAvaliacao(AvaliacaoDTO avaliacaoDTO);
	
	Avaliacao alterarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO);
	
	void excluirAvaliacao(Integer id);

}
