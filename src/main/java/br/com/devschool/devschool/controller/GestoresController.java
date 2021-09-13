package br.com.devschool.devschool.controller;


import br.com.devschool.devschool.model.Gestores;
import br.com.devschool.devschool.model.dto.GestoresDTO;
import br.com.devschool.devschool.service.Gestores.GestoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestores")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class GestoresController {

    private final GestoresService gestoresService;


    @GetMapping
    public ResponseEntity<List<GestoresDTO>> listarGestores() {
        List<Gestores> gestores = gestoresService.listarGestores();
        return ResponseEntity.ok(GestoresDTO.converter(gestores));
    }

    @PostMapping
    public ResponseEntity<GestoresDTO> inserirGestor(@RequestBody GestoresDTO gestoresDTO) {
        Gestores gestores = gestoresService.inserirGestor(gestoresDTO);
        return ResponseEntity.ok(new GestoresDTO(gestores));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestoresDTO> alterarGestor(@PathVariable Integer id, @RequestBody GestoresDTO gestoresDTO) {
        Gestores gestores = gestoresService.alterarGestor(id, gestoresDTO);
        return ResponseEntity.ok(new GestoresDTO(gestores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirGestor(@PathVariable Integer id) {
        gestoresService.excluirGestor(id);
        return ResponseEntity.ok().build();
    }
}
