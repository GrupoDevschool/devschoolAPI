package br.com.devschool.devschool.service.Avaliacao;

import java.util.List;

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;

public interface AvaliacaoService {
	
	public List<Avaliacao> listarAvaliacoes();
	
	public Avaliacao inserirAvaliacao(AvaliacaoDTO avaliacaoDTO);
	
	public Avaliacao alterarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO);
	
	public void excluirAvaliacao(Integer id);

}
