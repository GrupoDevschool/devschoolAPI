package br.com.devschool.devschool.service.Tarefa.Avaliacao;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.formDto.AvaliacaoFormDTO;
import br.com.devschool.devschool.repository.AvaliacaoRepository;
import br.com.devschool.devschool.service.Gestor.GestorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TarefaServiceImpl implements TarefaService {

	private final AvaliacaoRepository avaliacaoRepository;
	private final GestorService gestorService;
	
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
	public Avaliacao inserirAvaliacao(AvaliacaoFormDTO avaliacaoDTO) {
		Gestor gestor = gestorService.listarGestorById(avaliacaoDTO.getGestorId());
		
		Avaliacao avaliacao = Avaliacao.builder()
				.descricao(avaliacaoDTO.getDescricao())
				.data(avaliacaoDTO.getData())
				.gestor(gestor)
				.build();
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public Avaliacao alterarAvaliacao(Integer id, AvaliacaoFormDTO avaliacaoDTO) {

		Avaliacao avaliacao = this.listarAvaliacoesById(id);
		
		Gestor gestor = gestorService.listarGestorById(avaliacaoDTO.getGestorId());
		
		avaliacao.setData(avaliacaoDTO.getData());
		avaliacao.setDescricao(avaliacaoDTO.getDescricao());
		avaliacao.setGestor(gestor);
		
		return avaliacaoRepository.save(avaliacao);
	}

	@Override
	public void excluirAvaliacao(Integer id) {
		this.listarAvaliacoesById(id);
		avaliacaoRepository.deleteById(id);
	}
	
	
	
}
