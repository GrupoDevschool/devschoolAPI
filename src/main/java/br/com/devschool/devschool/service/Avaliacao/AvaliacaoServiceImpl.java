package br.com.devschool.devschool.service.Avaliacao;

import java.util.List;
import java.util.Optional;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Aula;
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
		return avaliacaoRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Avaliacao com id "+ id + " não encontrada"));
	}

	@Override
	public Avaliacao inserirAvaliacao(AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = Avaliacao.builder()
				.descricao(avaliacaoDTO.getDescricao())
				.data(avaliacaoDTO.getData())
				.gestor(avaliacaoDTO.getGestor())
				.build();
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public Avaliacao alterarAvaliacao(Integer id, AvaliacaoDTO avaliacaoDTO) {

		Avaliacao avaliacao = this.listarAvaliacoesById(id);

		avaliacao.setData(avaliacaoDTO.getData());
		avaliacao.setDescricao(avaliacaoDTO.getDescricao());
		
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void excluirAvaliacao(Integer id) {
		this.listarAvaliacoesById(id);
		avaliacaoRepository.deleteById(id);
	}
	
	
	
}
