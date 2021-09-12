package br.com.devschool.devschool.controller;


import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.model.dto.ChamadaDTO;
import br.com.devschool.devschool.model.dto.TrilhaDTO;
import br.com.devschool.devschool.service.Chamada.ChamadaService;
import br.com.devschool.devschool.service.Trilha.TrilhaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamada")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ChamadaController {

    private ChamadaService chamadaService;

    @GetMapping
    public ResponseEntity<List<ChamadaDTO>> ListarChamadas() {
        List<Chamada> chamadas = chamadaService.ListarChamadas();
        return ResponseEntity.ok(ChamadaDTO.converter(chamadas));
    }

    @PostMapping
    public ResponseEntity<ChamadaDTO> inserirChamadas(@RequestBody ChamadaDTO chamadaDTO) {
        Chamada chamada = chamadaService.inserirChamadas(chamadaDTO);
        return ResponseEntity.ok(new ChamadaDTO(chamada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadaDTO> alterarChamada(@PathVariable Integer id, @RequestBody ChamadaDTO chamadaDTO) {
        Chamada chamada = chamadaService.alterarChamada(id, chamadaDTO);
        return ResponseEntity.ok(new ChamadaDTO(chamada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirChamada(@PathVariable Integer id) {
        chamadaService.excluirChamada(id);
        return ResponseEntity.ok().build();
    }
}
