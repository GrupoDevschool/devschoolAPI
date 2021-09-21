package br.com.devschool.devschool.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.Questoes;
import br.com.devschool.devschool.model.Resposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestoesDTO {
    
	private Integer id;
    private Integer idAvaliacao;
    private Integer numero;
    private List<Integer> perguntaResposta;

    public QuestoesDTO(Questoes questoes) {
        this.id = questoes.getId();
    	this.idAvaliacao = questoes.getAvaliacao().getId();
        this.numero = questoes.getNumero();
        
        Pergunta pergunta = questoes.getPergunta();
        List<Resposta> respostas = questoes.getResposta();
        this.perguntaResposta = new ArrayList<Integer>();
        this.perguntaResposta.add(pergunta.getId());
        respostas.forEach(resposta -> this.perguntaResposta.add(resposta.getId()));
    }

    public static List<QuestoesDTO> converter(List<Questoes> questoes) {
        return questoes.stream().map(QuestoesDTO::new).collect(Collectors.toList());
    }

    public static List<Questoes>converterList(List<QuestoesDTO> questoes) {
        return questoes.stream().map(Questoes::new).collect(Collectors.toList());
    }
}
