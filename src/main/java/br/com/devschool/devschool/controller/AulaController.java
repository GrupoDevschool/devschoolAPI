package br.com.devschool.devschool.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.model.formDto.AulaFormDTO;
import br.com.devschool.devschool.service.Aula.AulaService;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping({"/aula", "/aulas"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AulaController {

    private final AulaService aulaService;

    @GetMapping
    public ResponseEntity<List<AulaDTO>> listarAulas(@RequestParam(name = "dataHora" , required = false) String dataHora, @RequestParam(name = "turmaId" , required = false) Integer turmaId ) {
        List<Aula> aulas = aulaService.listarAulas(dataHora, turmaId);
        return ResponseEntity.ok(AulaDTO.converter(aulas));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<AulaDTO> listarAreaById(@PathVariable Integer id ) {
        AulaDTO aulaDTO = new AulaDTO(aulaService.listarAulaById(id));
        return ResponseEntity.ok(aulaDTO);
    }


    @PostMapping
    public ResponseEntity<AulaDTO> inserirAulas(@RequestBody @Valid AulaFormDTO aulaDTO) {
        Aula aula = aulaService.inserirAula(aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaDTO> alterarAulas(@PathVariable Integer id, @RequestBody @Valid AulaFormDTO aulaDTO) {
        Aula aula = aulaService.alterarAula(id, aulaDTO);
        return ResponseEntity.ok(new AulaDTO(aula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirAula(@PathVariable Integer id) {
        aulaService.excluirAula(id);
        return ResponseEntity.ok().build();
    }
}
