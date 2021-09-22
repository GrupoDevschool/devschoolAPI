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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.dto.QuestoesDTO;
import br.com.devschool.devschool.model.formDto.QuestaoFormDto;
import br.com.devschool.devschool.service.Questoes.QuestoesService;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping({"/questoes", "questao"})
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class QuestoesController {

    private final QuestoesService questoesService;

    @GetMapping
    public ResponseEntity<List<QuestoesDTO>> listarQuestoes(@RequestParam(required = false, name = "avaliacaoId") Integer avaliacaoId) {
        List<Questoes> questoes = questoesService.listarQuestoes(avaliacaoId);
        return ResponseEntity.ok(QuestoesDTO.converter(questoes));
    }

    @GetMapping("/{id}" )
    public ResponseEntity<QuestoesDTO> listarQuestoesById(@PathVariable Integer id ) {
        QuestoesDTO questoesDTO = new QuestoesDTO(questoesService.listarQuestoesById(id));
        return ResponseEntity.ok(questoesDTO);
    }

    @PostMapping
    public ResponseEntity<QuestoesDTO> inserirQuestoes(@RequestBody @Valid QuestaoFormDto questoesDTO) {
        Questoes questoes = questoesService.inserirQuestoes(questoesDTO);
        return ResponseEntity.ok(new QuestoesDTO(questoes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestoesDTO> alterarQuestoes(@PathVariable Integer id, @RequestBody @Valid QuestaoFormDto questoesDTO) {
        Questoes questoes = questoesService.alterarQuestoes(id, questoesDTO);
        return ResponseEntity.ok(new QuestoesDTO(questoes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirQuestao(@PathVariable Integer id) {
        questoesService.excluirQuestao(id);
        return ResponseEntity.ok().build();
    }

}
