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

import br.com.devschool.devschool.model.AulaGestor;
import br.com.devschool.devschool.model.dto.AulaGestorDTO;
import br.com.devschool.devschool.model.formDto.AulaGestorFormDTO;
import br.com.devschool.devschool.service.aulaGestor.AulaGestorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aulaGestor")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AulaGestorController {

	private final AulaGestorService aulaGestorService;
	
	@GetMapping
	public ResponseEntity<List<AulaGestorDTO>> listarAulaGestor() {
		List<AulaGestor> aulasGestores = aulaGestorService.listarAulasGestores();
		return ResponseEntity.ok(AulaGestorDTO.converter(aulasGestores));
	}
	
	@PostMapping 
	public ResponseEntity<AulaGestorDTO> inserirAulaGestor(@RequestBody AulaGestorFormDTO aulaGestorDTO) {
		AulaGestor aulaGestor = aulaGestorService.inserirAulaGestor(aulaGestorDTO);
		return ResponseEntity.ok(new AulaGestorDTO(aulaGestor));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AulaGestorDTO> alterarAulaGestor(@PathVariable Integer id, @RequestBody AulaGestorFormDTO aulaGestorDTO){
		AulaGestor aulaGestor = aulaGestorService.alterarAulaGestor(id, aulaGestorDTO);
		return ResponseEntity.ok(new AulaGestorDTO(aulaGestor));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity excluirAulaGestor(@PathVariable Integer id) {
		aulaGestorService.excluirAulaGestor(id);
		return ResponseEntity.ok().build();
	}
	
}
