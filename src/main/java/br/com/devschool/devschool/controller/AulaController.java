package br.com.devschool.devschool.controller;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.service.Aula.AulaServie;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AulaController {

    private final AulaServie areaService;


    @GetMapping
    public ResponseEntity<List<AulaDTO>> listarAulas() {
        List<Aula> aulas = areaService.listarAulas();
        return ResponseEntity.ok(AulaDTO.converter(aulas));
    }

    @PostMapping
    public ResponseEntity<AulaDTO> inserirAulas(@RequestBody AulaDTO aulaDTO) {
        Aula aula = areaService.inserirAula(aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaDTO> alterarAulas(@PathVariable Integer id, @RequestBody AulaDTO aulaDTO) {
        Aula aula = areaService.alterarAula(id, aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirAula(@PathVariable Integer id) {
        areaService.excluirAula(id);
        return ResponseEntity.ok().build();
    }
}
