package br.com.devschool.devschool.controller;

import br.com.devschool.devschool.model.Grupo;
import br.com.devschool.devschool.model.dto.GrupoDTO;
import br.com.devschool.devschool.model.formDto.GrupoFormDTO;
import br.com.devschool.devschool.service.Grupo.GrupoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/grupo", "/grupos"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class GrupoController {
    private final GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listarGrupos() {
        List<Grupo> grupos = grupoService.listarGrupos();
        return ResponseEntity.ok(GrupoDTO.converter(grupos));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<GrupoDTO> buscarGrupoPorId(@PathVariable Integer id ) {
        GrupoDTO grupoDTO = new GrupoDTO(grupoService.buscarGrupoPorId(id));
        return ResponseEntity.ok(grupoDTO);
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> inserirGrupo(@RequestBody @Valid GrupoFormDTO grupoDTO) {
        GrupoDTO grupo = new GrupoDTO(grupoService.inserirGrupo(grupoDTO));
        return ResponseEntity.ok(grupo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> alterarGrupo(@PathVariable Integer id, @RequestBody @Valid GrupoFormDTO grupoDTO) {
        Grupo grupo = grupoService.alterarGrupo(id, grupoDTO);
        return ResponseEntity.ok(new GrupoDTO(grupo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirGrupo(@PathVariable Integer id) {
        grupoService.excluirGrupo(id);
        return ResponseEntity.ok().build();
    }
}
