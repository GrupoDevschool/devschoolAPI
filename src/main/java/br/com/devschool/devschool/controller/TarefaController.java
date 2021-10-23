package br.com.devschool.devschool.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.devschool.devschool.service.Tarefa.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.devschool.model.Tarefa;
import br.com.devschool.devschool.model.dto.TarefaDTO;
import br.com.devschool.devschool.model.formDto.TarefaFormDTO;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/tarefas", "/tarefa"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TarefaController {

	private final TarefaService tarefaService;

	@GetMapping
	public ResponseEntity<List<TarefaDTO>> listarTarefas(@RequestParam(required = false, name = "grupoId") Integer grupoId) {
		List<Tarefa> tarefas = tarefaService.listarTarefas(grupoId);
		return ResponseEntity.ok(TarefaDTO.converter(tarefas));
	}

	@GetMapping("/{id}" )
	public ResponseEntity<TarefaDTO> listarTarefasById(@PathVariable Integer id ) {
		TarefaDTO tarefaDTO = new TarefaDTO(tarefaService.listarTarefasById(id));
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
