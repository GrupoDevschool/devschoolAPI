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

import br.com.devschool.devschool.model.Turma;
import br.com.devschool.devschool.model.dto.TurmaDTO;
import br.com.devschool.devschool.model.formDto.TurmaFormDTO;
import br.com.devschool.devschool.service.Turma.TurmaService;
import lombok.AllArgsConstructor;

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
    public ResponseEntity<TurmaDTO> inserirTurma(@RequestBody TurmaFormDTO turmaDTO) {
        TurmaDTO turma = new TurmaDTO(turmaService.inserirTurma(turmaDTO));
        return ResponseEntity.ok(turma);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> alterarTurma(@PathVariable Integer id, @RequestBody TurmaFormDTO turmaDTO) {
        Turma turma = turmaService.alterarTurma(id, turmaDTO);
        return ResponseEntity.ok(new TurmaDTO(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirTurma(@PathVariable Integer id) {
        turmaService.excluirTurma(id);
        return ResponseEntity.ok().build();
    }
}
