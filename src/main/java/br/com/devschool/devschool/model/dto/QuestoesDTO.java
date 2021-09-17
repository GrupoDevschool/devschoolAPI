package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Questoes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestoesDTO {
    private Integer id;

    private Integer ordem;

    private PerguntaDTO pergunta;

    public QuestoesDTO(Questoes questoes) {
        this.id = questoes.getId();
        this.ordem = questoes.getOrdem();
        if (pergunta.getRespostas() != null) {
            this.pergunta = (PerguntaDTO) PerguntaDTO.converter(questoes.getPergunta());
        }
    }

    public static List<QuestoesDTO> converter(List<Questoes> questoes) {
        return questoes.stream().map(QuestoesDTO::new).collect(Collectors.toList());
    }

    public static List<Questoes>converterList(List<QuestoesDTO> questoes) {
        return questoes.stream().map(Questoes::new).collect(Collectors.toList());
    }
}
