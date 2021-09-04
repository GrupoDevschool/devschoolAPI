package br.com.devschool.devschool.service.avaliacao;

import java.util.List;

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;
import br.com.devschool.devschool.repository.AvaliacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AvaliacaoServiceImpl implements AvaliacaoService{

	private final AvaliacaoRepository avaliacaoRepository;
	
	@Override
	public List<Avaliacao> listarAvaliacoes() {
		List<Avaliacao> avaliacoes = avaliacaoRepository.findAll();
		return avaliacoes;
	}

	@Override
	public Avaliacao inserirAvaliacao(AvaliacaoDTO avaliacaoDTO) {
		
		return null;
	}

	@Override
	public Avaliacao alterarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirAvaliacao(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
