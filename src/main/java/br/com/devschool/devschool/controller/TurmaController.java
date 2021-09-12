package br.com.devschool.devschool.controller;

import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.dto.TurmaDTO;
import br.com.devschool.devschool.service.Turma.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TurmaController {
    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> listarTurmas() {
        List<Turma> turmas = turmaService.listarTurmas();
        return ResponseEntity.ok(TurmaDTO.converter(turmas));
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> inserirTurma(@RequestBody TurmaDTO turmaDTO) {
        TurmaDTO turma = new TurmaDTO(turmaService.inserirTurma(turmaDTO));
        return ResponseEntity.ok(turma);

    }

    @PutMapping("/{numero}")
    public ResponseEntity<TurmaDTO> alterarTurma(@PathVariable Integer numero, @RequestBody TurmaDTO turmaDTO) {
        Turma turma = turmaService.alterarTurma(numero, turmaDTO);
        return ResponseEntity.ok(new TurmaDTO(turma));
    }

    @DeleteMapping("{numero}")
    public ResponseEntity excluirTurma(@PathVariable Integer numero) {
        turmaService.excluirTurma(numero);
        return ResponseEntity.ok().build();
    }
}
