package br.com.devschool.devschool.controller;


import java.util.List;

import javax.validation.Valid;

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

import br.com.devschool.devschool.model.Area;
import br.com.devschool.devschool.model.dto.AreaDTO;
import br.com.devschool.devschool.service.Area.AreaService;
import lombok.AllArgsConstructor;

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


    @GetMapping("/{id}" )
    public ResponseEntity<AreaDTO> listarAreaById(@PathVariable Integer id ) {
        AreaDTO areaDTO = new AreaDTO(areaService.listarAreaById(id));
        return ResponseEntity.ok(areaDTO);
    }



    @PostMapping
    public ResponseEntity<AreaDTO> inserirArea(@RequestBody @Valid AreaDTO areaDTO) {
        Area area = areaService.inserirArea(areaDTO);
        return ResponseEntity.ok(new AreaDTO(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> alterarArea(@PathVariable Integer id, @RequestBody @Valid AreaDTO areaDTO) {
        Area area = areaService.alterarArea(id, areaDTO);
        return ResponseEntity.ok(new AreaDTO(area));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirArea(@PathVariable Integer id) {
        areaService.excluirArea(id);
        return ResponseEntity.ok().build();
    }

}
