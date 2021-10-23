package br.com.devschool.devschool.controller;

import br.com.devschool.devschool.model.Tarefa;
import br.com.devschool.devschool.model.dto.TarefaDTO;
import br.com.devschool.devschool.model.formDto.TarefaFormDTO;
import br.com.devschool.devschool.service.Tarefa.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/tarefas", "/tarefa"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TarefaController {
	
	private final TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> listarAvaliacoes(@RequestParam(required = false, name = "grupoId") Integer grupoId) {
		List<Tarefa> tarefas = tarefaService.listarAvaliacoes(grupoId);
		return ResponseEntity.ok(TarefaDTO.converter(tarefas));
	}

	@GetMapping("/{id}" )
	public ResponseEntity<TarefaDTO> listarAvaliacoesById(@PathVariable Integer id ) {
		TarefaDTO tarefaDTO = new TarefaDTO(tarefaService.listarAvaliacoesById(id));
		return ResponseEntity.ok(tarefaDTO);
	}


	@PostMapping
	public ResponseEntity<TarefaDTO> inserirTarefa(@RequestBody @Valid TarefaFormDTO tarefaDTO) {
		Tarefa tarefa = tarefaService.inserirTarefa(tarefaDTO);
		return ResponseEntity.ok(new TarefaDTO(tarefa));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TarefaDTO> alterarTarefa(@PathVariable Integer id, @RequestBody @Valid TarefaFormDTO tarefaDTO) {
		Tarefa tarefa = tarefaService.alterarTarefa(id, tarefaDTO);
		return ResponseEntity.ok(new TarefaDTO(tarefa));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirTarefa(@PathVariable Integer id) {
		tarefaService.excluirTarefa(id);
		return ResponseEntity.ok().build();
	}
}
