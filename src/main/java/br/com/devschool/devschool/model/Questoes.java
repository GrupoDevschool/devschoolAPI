package br.com.devschool.devschool.model;

import br.com.devschool.devschool.model.dto.GestorDTO;
import br.com.devschool.devschool.model.dto.QuestoesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ordem;

    private Integer tipo;

    @ManyToMany
    private List<Pergunta> pergunta;


    @ManyToOne
    private Avaliacao avaliacao;


    public Questoes(QuestoesDTO questoesDTO) {
        this.id = questoesDTO.getId();
        this.ordem = questoesDTO.getOrdem();
        this.tipo = questoesDTO.getOrdem();
        //this.pergunta = questoesDTO.getPergunta();
    }

    public static List<Questoes> converter(List<QuestoesDTO> questoes) {
        if (questoes == null) return null;
        return questoes.stream().map(Questoes::new).collect(Collectors.toList());
    }
}
