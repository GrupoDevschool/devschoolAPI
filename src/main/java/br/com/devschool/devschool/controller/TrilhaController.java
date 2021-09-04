package br.com.devschool.devschool.controller;

import br.com.devschool.devschool.dto.TrilhaDTO;
import br.com.devschool.devschool.service.trilha.TrilhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    private TrilhaService trilhaService;


    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }



    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> getAllTrilhas() {
        List<TrilhaDTO> trilhas = TrilhaDTO.convertList(trilhaService.getAllTrilha());
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> getTrilhaById(@PathVariable Long id) {
        TrilhaDTO trilha = new TrilhaDTO(trilhaService.getTrilhaById(id));
        return ResponseEntity.ok(trilha);
    }

    @PostMapping
    public ResponseEntity<TrilhaDTO> createTrilha(@RequestBody TrilhaDTO trilhaDTO) {
        TrilhaDTO trilha = new TrilhaDTO(trilhaService.createTrilha(trilhaDTO));
        return ResponseEntity.ok(trilha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> updateTrilha(@PathVariable Long id,@RequestBody TrilhaDTO trilhaDTO) {
        TrilhaDTO trilha = new TrilhaDTO(trilhaService.updateTrilha(id, trilhaDTO));
        return ResponseEntity.ok(trilha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateTrilha(@PathVariable Long id) {
        trilhaService.deleteTrilha(id);
        return ResponseEntity.noContent().build();
    }
}
