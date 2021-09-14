package br.com.devschool.devschool.controller;


import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.model.dto.AulaDTO;
import br.com.devschool.devschool.service.Area.AreaService;
import br.com.devschool.devschool.service.Aula.AulaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/area", "/areas"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AreaController {
    private final AreaService areaService;


    @GetMapping
    public ResponseEntity<List<AreaDTO>> listarAreas() {
        List<Area> areas = areaService.listarAreas();
        return ResponseEntity.ok(AreaDTO.converter(areas));
    }

    @PostMapping
    public ResponseEntity<AreaDTO> inserirArea(@RequestBody AreaDTO areaDTO) {
        Area area = areaService.inserirArea(areaDTO);
        return ResponseEntity.ok(new AreaDTO(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> alterarArea(@PathVariable Integer id, @RequestBody AreaDTO areaDTO) {
        Area area = areaService.alterarArea(id, areaDTO);
        return ResponseEntity.ok(new AreaDTO(area));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirArea(@PathVariable Integer id) {
        areaService.excluirArea(id);
        return ResponseEntity.ok().build();
    }

}
