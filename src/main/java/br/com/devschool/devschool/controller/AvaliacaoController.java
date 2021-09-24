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

import br.com.devschool.devschool.model.Avaliacao;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;
import br.com.devschool.devschool.model.formDto.AvaliacaoFormDTO;
import br.com.devschool.devschool.service.Avaliacao.AvaliacaoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/avaliacoes", "/avaliacao"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AvaliacaoController {
	
	private final AvaliacaoService avaliacaoService;
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDTO>> listarAvaliacoes(@RequestParam(required = false, name = "gestorId") Integer gestorId) {
		List<Avaliacao> avaliacaos = avaliacaoService.listarAvaliacoes(gestorId);
		return ResponseEntity.ok(AvaliacaoDTO.converter(avaliacaos));
	}

	@GetMapping("/{id}" )
	public ResponseEntity<AvaliacaoDTO> listarAvaliacoesById(@PathVariable Integer id ) {
		AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(avaliacaoService.listarAvaliacoesById(id));
		return ResponseEntity.ok(avaliacaoDTO);
	}


	@PostMapping
	public ResponseEntity<AvaliacaoDTO> inserirAvaliacao(@RequestBody @Valid AvaliacaoFormDTO avaliacaoDTO) {
		Avaliacao avaliacao = avaliacaoService.inserirAvaliacao(avaliacaoDTO);
		return ResponseEntity.ok(new AvaliacaoDTO(avaliacao));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoDTO> alterarAvaliacao(@PathVariable Integer id, @RequestBody @Valid AvaliacaoFormDTO avaliacaoDTO) {
		Avaliacao avaliacao = avaliacaoService.alterarAvaliacao(id, avaliacaoDTO);
		return ResponseEntity.ok(new AvaliacaoDTO(avaliacao));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirAvaliacao(@PathVariable Integer id) {
		avaliacaoService.excluirAvaliacao(id);
		return ResponseEntity.ok().build();
	}
}
