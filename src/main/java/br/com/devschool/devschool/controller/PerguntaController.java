package br.com.devschool.devschool.controller;

import java.util.List;

import br.com.devschool.devschool.model.dto.GestorDTO;
import org.springframework.data.repository.query.Param;
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

import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.dto.PerguntaDTO;
import br.com.devschool.devschool.model.formDto.PerguntaFormDTO;
import br.com.devschool.devschool.service.Pergunta.PerguntaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({ "/pergunta", "/perguntas" })
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PerguntaController {

	private final PerguntaService perguntaService;

	@GetMapping
	public ResponseEntity<List<PerguntaDTO>> listarPerguntas(@RequestParam(required = false) Integer disciplinaId) {
		List<Pergunta> perguntas = perguntaService.listarPerguntas(disciplinaId);
		return ResponseEntity.ok(PerguntaDTO.converter(perguntas));
	}

	@GetMapping("/{id}" )
	public ResponseEntity<PerguntaDTO> listarPerguntaById(@PathVariable Integer id ) {
		PerguntaDTO perguntaDTO = new PerguntaDTO(perguntaService.listarPerguntaById(id));
		return ResponseEntity.ok(perguntaDTO);
	}


	@PostMapping
	public ResponseEntity<PerguntaDTO> inserirPergunta(@RequestBody PerguntaFormDTO perguntaDTO) {
		Pergunta pergunta = perguntaService.inserirPergunta(perguntaDTO);
		return ResponseEntity.ok(new PerguntaDTO(pergunta));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PerguntaDTO> alterarPergunta(@PathVariable Integer id, @RequestBody PerguntaFormDTO perguntaDTO) {
		Pergunta pergunta = perguntaService.alterarPergunta(id, perguntaDTO);
		return ResponseEntity.ok(new PerguntaDTO(pergunta));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirPergunta(@PathVariable Integer id) {
		perguntaService.excluirPergunta(id);
		return ResponseEntity.ok().build();
	}

}
