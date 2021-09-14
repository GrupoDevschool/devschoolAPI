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

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;
import br.com.devschool.devschool.model.formDto.ChamadaFormDTO;
import br.com.devschool.devschool.service.Aula.AulaService;
import br.com.devschool.devschool.service.Chamada.ChamadaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aula")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AulaController {

    private final AulaService areaService;

    @GetMapping
    public ResponseEntity<List<AulaDTO>> listarAulas() {
        List<Aula> aulas = areaService.listarAulas();
        return ResponseEntity.ok(AulaDTO.converter(aulas));
    }

    @PostMapping
    public ResponseEntity<AulaDTO> inserirAulas(@RequestBody AulaFormDTO aulaDTO) {
        Aula aula = areaService.inserirAula(aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaDTO> alterarAulas(@PathVariable Integer id, @RequestBody AulaFormDTO aulaDTO) {
        Aula aula = areaService.alterarAula(id, aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirAula(@PathVariable Integer id) {
        areaService.excluirAula(id);
        return ResponseEntity.ok().build();
    }
}
