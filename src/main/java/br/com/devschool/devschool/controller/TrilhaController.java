package br.com.devschool.devschool.controller;

import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.model.dto.TrilhaDTO;
import br.com.devschool.devschool.service.Trilha.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trilhas")
@CrossOrigin(origins = "*")
public class TrilhaController {

    private TrilhaService trilhaService;

    @Autowired
    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }



    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> getAllTrilhas() {
        List<TrilhaDTO> trilhas = TrilhaDTO.convertList(trilhaService.getAllTrilha());
        return ResponseEntity.ok(trilhas);
    }

    @GetMapping("/{id}" )
    public ResponseEntity<TrilhaDTO> getTrilhaById(@PathVariable Long id ) {
        TrilhaDTO trilhaDTO = new TrilhaDTO(trilhaService.getTrilhaById(id));
        return ResponseEntity.ok(trilhaDTO);
    }

    @PostMapping
    public ResponseEntity<TrilhaDTO> createTrilha(@RequestBody @Valid TrilhaDTO trilhaDTO) {
        TrilhaDTO trilha = new TrilhaDTO(trilhaService.createTrilha(trilhaDTO));
        return ResponseEntity.ok(trilha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> updateTrilha(@PathVariable Long id,@RequestBody @Valid TrilhaDTO trilhaDTO) {
        TrilhaDTO trilha = new TrilhaDTO(trilhaService.updateTrilha(id, trilhaDTO));
        return ResponseEntity.ok(trilha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateTrilha(@PathVariable Long id) {
        trilhaService.deleteTrilha(id);
        return ResponseEntity.noContent().build();
    }
}
