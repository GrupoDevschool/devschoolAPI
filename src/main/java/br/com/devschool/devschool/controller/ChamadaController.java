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

import br.com.devschool.devschool.model.Chamada;
import br.com.devschool.devschool.model.dto.ChamadaDTO;
import br.com.devschool.devschool.model.formDto.ChamadaFormDTO;
import br.com.devschool.devschool.service.Chamada.ChamadaService;
import lombok.AllArgsConstructor;

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
    public ResponseEntity<ChamadaDTO> inserirChamadas(@RequestBody ChamadaFormDTO chamadaDTO) {
        Chamada chamada = chamadaService.inserirChamadas(chamadaDTO);
        return ResponseEntity.ok(new ChamadaDTO(chamada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChamadaDTO> alterarChamada(@PathVariable Integer id, @RequestBody ChamadaFormDTO chamadaDTO) {
        Chamada chamada = chamadaService.alterarChamada(id, chamadaDTO);
        return ResponseEntity.ok(new ChamadaDTO(chamada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirChamada(@PathVariable Integer id) {
        chamadaService.excluirChamada(id);
        return ResponseEntity.ok().build();
    }
}
