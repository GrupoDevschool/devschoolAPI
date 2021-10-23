package br.com.devschool.devschool.service.Tarefa;

import br.com.devschool.devschool.model.Tarefa;
import br.com.devschool.devschool.model.formDto.TarefaFormDTO;

import java.util.List;

public interface TarefaService {
	
	List<Tarefa> listarTarefas(Integer grupoId);

	Tarefa listarTarefasById(Integer id);
	
	Tarefa inserirTarefa(TarefaFormDTO tarefaDTO);
	
	Tarefa alterarTarefa(Integer id, TarefaFormDTO tarefaDTO);
	
	void excluirTarefa(Integer id);

}
