package br.com.devschool.devschool.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.service.disciplina.DisciplinaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/disciplinas")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DisciplinaController {
	
	private final DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> listarDisciplinas() {
		List<Disciplina> disciplinas = disciplinaService.listarDisciplinas();
		return ResponseEntity.ok(DisciplinaDTO.converter(disciplinas));
	}
	
	@PostMapping
	public ResponseEntity<DisciplinaDTO> inserirDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
		Disciplina disciplina = disciplinaService.inserirDisciplina(disciplinaDTO);
		
		return ResponseEntity.ok(new DisciplinaDTO(disciplina));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DisciplinaDTO> alterarDisciplina(@PathVariable Integer id,@RequestBody DisciplinaDTO disciplinaDTO) {
		Disciplina disciplina = disciplinaService.alterarDisciplina(id, disciplinaDTO);
		
		return ResponseEntity.ok(new DisciplinaDTO(disciplina));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity excluirDisciplina(@PathVariable Integer id) {
		disciplinaService.excluirDisciplina(id);
		
		return ResponseEntity.ok().build();
	}
}
