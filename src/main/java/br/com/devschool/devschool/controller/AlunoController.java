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

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(AlunoDTO.converter(alunos));
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
