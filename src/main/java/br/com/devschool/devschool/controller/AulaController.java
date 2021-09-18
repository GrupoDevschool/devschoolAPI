package br.com.devschool.devschool.controller;
import java.util.List;

import br.com.devschool.devschool.model.dto.AreaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;
import br.com.devschool.devschool.service.Aula.AulaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/aula", "/aulas"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AulaController {

    private final AulaService areaService;

    @GetMapping
    public ResponseEntity<List<AulaDTO>> listarAulas() {
        List<Aula> aulas = areaService.listarAulas();
        return ResponseEntity.ok(AulaDTO.converter(aulas));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<AulaDTO> listarAreaById(@PathVariable Integer id ) {
        AulaDTO aulaDTO = new AulaDTO(areaService.listarAulaById(id));
        return ResponseEntity.ok(aulaDTO);
    }

    @GetMapping ( "aula/{datahora}")
    public ResponseEntity<AulaDTO> listarAreaByDate(@PathVariable String dataHora ) {
        AulaDTO aulaDTO = new AulaDTO(areaService.listarAulaByDate(dataHora));
        return ResponseEntity.ok(aulaDTO);
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
