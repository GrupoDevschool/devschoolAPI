package br.com.devschool.devschool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.dto.AlunoDTO;
import br.com.devschool.devschool.model.formDto.AlunoFormDTO;
import br.com.devschool.devschool.service.Aluno.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping ({"/alunos", "/aluno"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoController {
    private final AlunoService alunoService;



    @GetMapping("/{matricula}" )
    public ResponseEntity<AlunoDTO> listarAlunoByMatricula(@PathVariable  Integer matricula ) {
        AlunoDTO alunoDTO = new AlunoDTO(alunoService.listarAlunoByMatricula(matricula));
        return ResponseEntity.ok(alunoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunosByTumaId(@RequestParam(name = "turmaId", required = false) Integer turmaId) {
        List<Aluno> aluno = (alunoService.listarAlunosByTurmaId(turmaId));
        return  ResponseEntity.ok(AlunoDTO.converter(aluno));
    }


    @PostMapping
    public ResponseEntity<AlunoDTO> inserirAluno(@RequestBody AlunoFormDTO alunoDTO) {
        AlunoDTO aluno = new AlunoDTO(alunoService.inserirAluno(alunoDTO));
        return ResponseEntity.ok(aluno);

    }

    @PutMapping("/{matricula}")
    public ResponseEntity<AlunoDTO> alterarAluno(@PathVariable Integer matricula, @RequestBody AlunoFormDTO alunoDTO) {
        Aluno aluno = alunoService.alterarAluno(matricula, alunoDTO);
        return ResponseEntity.ok(new AlunoDTO(aluno));
    }

    @DeleteMapping("{matricula}")
    public ResponseEntity excluirAluno(@PathVariable Integer matricula) {
        alunoService.excluirAluno(matricula);
        return ResponseEntity.ok().build();
    }

}
