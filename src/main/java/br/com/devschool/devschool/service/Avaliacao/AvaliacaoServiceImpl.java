package br.com.devschool.devschool.service.Avaliacao;

import java.util.List;
import java.util.Optional;

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
	public List<Avaliacao> listarAvaliacoes(Integer gestorId) {
		if (gestorId != null) {
			return avaliacaoRepository.findAllByGestor_Id(gestorId);
		}
		return avaliacaoRepository.findAll();
	}

	@Override
	public Avaliacao listarAvaliacoesById(Integer id) {
		return avaliacaoRepository.findById(id).get();
	}

	@Override
	public Avaliacao inserirAvaliacao(AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = Avaliacao.builder()
				.descricao(avaliacaoDTO.getDescricao())
				.data(avaliacaoDTO.getData())
				.build();
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public Avaliacao alterarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO) {
		Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
		
		if (avaliacaoOptional.isEmpty()) {
			throw new RuntimeException("Avaliacao nao encontrada");
		}
		
		Avaliacao avaliacao = avaliacaoOptional.get();
		
		avaliacao.setData(avaliacaoDTO.getData());
		avaliacao.setDescricao(avaliacaoDTO.getDescricao());
		
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void excluirAvaliacao(Integer id) {
		Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(id);
		
		if (avaliacaoOptional.isEmpty()) {
			throw new RuntimeException("Avaliacao nao encontrada");
		}
		
		avaliacaoRepository.deleteById(id);
	}
	
	
	
}
