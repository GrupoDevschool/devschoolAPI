package br.com.devschool.devschool.controller;


import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.dto.AvaliacaoDTO;
import br.com.devschool.devschool.model.dto.QuestoesDTO;
import br.com.devschool.devschool.service.Questoes.QuestoesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QuestoesController {

    private final QuestoesService questoesService;

    @GetMapping
    public ResponseEntity<List<QuestoesDTO>> listarQuestoes() {
        List<Questoes> questoes = questoesService.listarQuestoes();
        return ResponseEntity.ok(QuestoesDTO.converter(questoes));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<QuestoesDTO> listarQuestoesById(@PathVariable Integer id ) {
        QuestoesDTO questoesDTO = new QuestoesDTO(questoesService.listarQuestoesById(id));
        return ResponseEntity.ok(questoesDTO);
    }

    @PostMapping
    public ResponseEntity<QuestoesDTO> inserirQuestoes(@RequestBody QuestoesDTO questoesDTO) {
        Questoes questoes = questoesService.inserirQuestoes(questoesDTO);
        return ResponseEntity.ok(new QuestoesDTO(questoes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestoesDTO> alterarQuestoes(@PathVariable Integer id, @RequestBody QuestoesDTO questoesDTO) {
        Questoes questoes = questoesService.alterarQuestoes(id, questoesDTO);
        return ResponseEntity.ok(new QuestoesDTO(questoes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirQuestao(@PathVariable Integer id) {
        questoesService.excluirQuestao(id);
        return ResponseEntity.ok().build();
    }

}
