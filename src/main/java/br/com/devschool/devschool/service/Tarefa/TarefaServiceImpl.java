package br.com.devschool.devschool.service.Tarefa;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Tarefa;
import br.com.devschool.devschool.model.Grupo;
import br.com.devschool.devschool.model.formDto.TarefaFormDTO;
import br.com.devschool.devschool.repository.TarefaRepository;
import br.com.devschool.devschool.service.Grupo.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class TarefaServiceImpl implements TarefaService {

	private final TarefaRepository tarefaRepository;
	private final GrupoService grupoService;
	
	@Override
	public List<Tarefa> listarTarefas(Integer grupoId) {
		if (grupoId != null) {
			return tarefaRepository.findAllByGrupo_Id(grupoId);
		}
		return tarefaRepository.findAll();
	}

	@Override
	public Tarefa listarTarefasById(Integer id) {
		return tarefaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Tarefa com id "+ id + " não encontrada"));
	}

	@Override
	public Tarefa inserirTarefa(TarefaFormDTO tarefaDTO) {
		Grupo grupo = grupoService.listarGrupoById(tarefaDTO.getGrupoId());
		
		Tarefa tarefa = Tarefa.builder()
				.descricao(tarefaDTO.getDescricao())
				.data(tarefaDTO.getData())
				.grupo(grupo)
				.build();
		return tarefaRepository.save(tarefa);
	}

	@Override
	public Tarefa alterarTarefa(Integer id, TarefaFormDTO tarefaDTO) {

		Tarefa tarefa = this.listarTarefasById(id);
		
		Grupo grupo = grupoService.listarGrupoById(tarefaDTO.getGrupoId());
		
		tarefa.setData(tarefaDTO.getData());
		tarefa.setDescricao(tarefaDTO.getDescricao());
		tarefa.setGrupo(grupo);
		
		return tarefaRepository.save(tarefa);
	}

	@Override
	public void excluirTarefa(Integer id) {
		this.listarTarefasById(id);
		tarefaRepository.deleteById(id);
	}
	
	
	
}
