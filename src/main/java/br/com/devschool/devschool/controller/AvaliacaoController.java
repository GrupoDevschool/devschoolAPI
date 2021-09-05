package br.com.devschool.devschool.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;
import br.com.devschool.devschool.service.avaliacao.AvaliacaoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/avaliacoes")
@AllArgsConstructor
public class AvaliacaoController {
	
	private final AvaliacaoService avaliacaoService;
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> listarAvaliacoes() {
		List<Avaliacao> avaliacoes = avaliacaoService.listarAvaliacoes();
		return ResponseEntity.ok(AvaliacaoDTO.converter(avaliacoes));
	}
	
	@PostMapping
	public ResponseEntity<AvaliacaoDTO> inserirAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = avaliacaoService.inserirAvaliacao(avaliacaoDTO);
		return ResponseEntity.ok(new AvaliacaoDTO(avaliacao));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoDTO> alterarAvaliacao(@PathVariable Integer id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = avaliacaoService.alterarAvaliacao(id, avaliacaoDTO);
		return ResponseEntity.ok(new AvaliacaoDTO(avaliacao));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirAvaliacao(@PathVariable Integer id) {
		avaliacaoService.excluirAvaliacao(id);
		return ResponseEntity.ok().build();
	}
}
