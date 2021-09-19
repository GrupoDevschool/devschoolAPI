package br.com.devschool.devschool.controller;


import java.util.List;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.dto.PresencaDTO;
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

import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.dto.RespostaDTO;
import br.com.devschool.devschool.model.formDto.RespostaFormDTO;
import br.com.devschool.devschool.service.Resposta.RespostaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/resposta", "/respostas"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RespostaController {
	
	private final RespostaService respostaService;

	@GetMapping
	public ResponseEntity<List<RespostaDTO>> listarRespostas(@RequestParam(name = "disciplinaId" ,required = false) Integer disciplinaId, @RequestParam(name = "areaId" , required = false) Integer areaId) {
		List<Resposta> respostas = respostaService.listarRespostas(disciplinaId, areaId);
		return ResponseEntity.ok(RespostaDTO.converter(respostas));
	}


	@GetMapping("/{id}" )
	public ResponseEntity<RespostaDTO> listarRespostaById(@PathVariable Integer id ) {
		RespostaDTO respostaDTO = new RespostaDTO(respostaService.listarRespostaById(id));
		return ResponseEntity.ok(respostaDTO);
	}

	@GetMapping("/{disciplina}" )
	public ResponseEntity<RespostaDTO> listarRespostaByDisciplinaId(@PathVariable Disciplina disciplina ) {
		RespostaDTO respostaDTO = new RespostaDTO(respostaService.findByDisciplina(disciplina));
		return ResponseEntity.ok(respostaDTO);
	}


	@PostMapping
	public ResponseEntity<RespostaDTO> inserirResposta(@RequestBody RespostaFormDTO respostaDTO) {
		Resposta resposta = respostaService.inserirResposta(respostaDTO);
		return ResponseEntity.ok(new RespostaDTO(resposta));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RespostaDTO> alterarResposta(@PathVariable Integer id, @RequestBody RespostaFormDTO respostaDTO) {
		Resposta resposta = respostaService.alterarResposta(id, respostaDTO);
		return ResponseEntity.ok(new RespostaDTO(resposta));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirResposta(@PathVariable Integer id) {
		respostaService.excluirResposta(id);
		return ResponseEntity.ok().build();
	}
	
}
