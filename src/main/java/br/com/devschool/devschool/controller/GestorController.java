package br.com.devschool.devschool.controller;


import br.com.devschool.devschool.model.Gestor;
import br.com.devschool.devschool.model.dto.GestorDTO;
import br.com.devschool.devschool.model.dto.TurmaDTO;
import br.com.devschool.devschool.service.Gestor.GestorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/gestor", "/gestores"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class GestorController {

    private final GestorService gestorService;


    @GetMapping
    public ResponseEntity<List<GestorDTO>> listarGestores() {
        List<Gestor> gestores = gestorService.listarGestores();
        return ResponseEntity.ok(GestorDTO.converter(gestores));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<GestorDTO> listarGestorById(@PathVariable Integer id ) {
        GestorDTO gestorDTO = new GestorDTO(gestorService.listarGestorById(id));
        return ResponseEntity.ok(gestorDTO);
    }

    @PostMapping
    public ResponseEntity<GestorDTO> inserirGestor(@RequestBody GestorDTO gestoresDTO) {
        Gestor gestores = gestorService.inserirGestor(gestoresDTO);
        return ResponseEntity.ok(new GestorDTO(gestores));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GestorDTO> alterarGestor(@PathVariable Integer id, @RequestBody GestorDTO gestorDTO) {
        Gestor gestores = gestorService.alterarGestor(id, gestorDTO);
        return ResponseEntity.ok(new GestorDTO(gestores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirGestor(@PathVariable Integer id) {
        gestorService.excluirGestor(id);
        return ResponseEntity.ok().build();
    }
}
