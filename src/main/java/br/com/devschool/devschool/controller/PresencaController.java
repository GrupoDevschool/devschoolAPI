package br.com.devschool.devschool.controller;


import java.util.List;

import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Aula;
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

import br.com.devschool.devschool.model.Presenca;
import br.com.devschool.devschool.model.dto.PresencaDTO;
import br.com.devschool.devschool.model.formDto.PresencaFormDTO;
import br.com.devschool.devschool.service.Presenca.PresencaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping({"/chamada" , "/presenca"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PresencaController {

    private PresencaService presencaService;

    @GetMapping
    public ResponseEntity<List<PresencaDTO>> ListarChamadas() {
        List<Presenca> presencas = presencaService.ListarChamadas();
        return ResponseEntity.ok(PresencaDTO.converter(presencas));
    }


    @GetMapping("/{id}" )
    public ResponseEntity<PresencaDTO> listarChamadaById(@PathVariable Integer id ) {
        PresencaDTO presencaDTO = new PresencaDTO(presencaService.listarChamadaById(id));
        return ResponseEntity.ok(presencaDTO);
    }

    @GetMapping("/{aula}" )
    public ResponseEntity<PresencaDTO> listarChamadaByAula(@PathVariable Aula aula ) {
        PresencaDTO presencaDTO = new PresencaDTO(presencaService.listarChamadaByAula(aula));
        return ResponseEntity.ok(presencaDTO);
    }

//    @GetMapping("/{aluno}" )
//    public ResponseEntity<PresencaDTO> listarChamadaByAluno(@PathVariable Aluno aluno ) {
//        PresencaDTO presencaDTO = new PresencaDTO(presencaService.listarChamadaByAluno(aluno));
//        return ResponseEntity.ok(presencaDTO);
//    }


    @PostMapping
    public ResponseEntity<PresencaDTO> inserirChamadas(@RequestBody PresencaFormDTO chamadaDTO) {
        Presenca presenca = presencaService.inserirChamadas(chamadaDTO);
        return ResponseEntity.ok(new PresencaDTO(presenca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresencaDTO> alterarChamada(@PathVariable Integer id, @RequestBody PresencaFormDTO chamadaDTO) {
        Presenca presenca = presencaService.alterarChamada(id, chamadaDTO);
        return ResponseEntity.ok(new PresencaDTO(presenca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirChamada(@PathVariable Integer id) {
        presencaService.excluirChamada(id);
        return ResponseEntity.ok().build();
    }
}
