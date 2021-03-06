package br.com.devschool.devschool.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.model.formDto.DisciplinaFormDTO;
import br.com.devschool.devschool.service.Disciplina.DisciplinaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/disciplinas" )
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DisciplinaController {
	
	private final DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> listarDisciplinas(@RequestParam(required = false, name = "areaId") Integer areaId) {
		List<Disciplina> disciplinas = disciplinaService.listarDisciplinas(areaId);
		return ResponseEntity.ok(DisciplinaDTO.converter(disciplinas));
	}



	@GetMapping("/{id}" )
	public ResponseEntity<DisciplinaDTO> getDisciplinaById(@PathVariable Integer id ) {
		DisciplinaDTO disciplinaDTO = new DisciplinaDTO(disciplinaService.getDisciplinaById(id));
		return ResponseEntity.ok(disciplinaDTO);
	}

	@PostMapping
	public ResponseEntity<DisciplinaDTO> inserirDisciplina(@RequestBody @Valid DisciplinaFormDTO disciplinaDTO) {
		Disciplina disciplina = disciplinaService.inserirDisciplina(disciplinaDTO);
		
		return ResponseEntity.ok(new DisciplinaDTO(disciplina));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DisciplinaDTO> alterarDisciplina(@PathVariable Integer id, @RequestBody @Valid DisciplinaFormDTO disciplinaDTO) {
		Disciplina disciplina = disciplinaService.alterarDisciplina(id, disciplinaDTO);
		
		return ResponseEntity.ok(new DisciplinaDTO(disciplina));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity excluirDisciplina(@PathVariable Integer id) {
		disciplinaService.excluirDisciplina(id);
		
		return ResponseEntity.ok().build();
	}
}
