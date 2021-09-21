package br.com.devschool.devschool.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.devschool.devschool.model.dto.QuestoesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    
    @ManyToOne
    private Pergunta pergunta;
    
    @ManyToMany
    @JoinTable(name="questao_resposta",
    joinColumns={@JoinColumn(name="questao_id")},
    inverseJoinColumns={@JoinColumn(name="resposta_id")})
    private List<Resposta> resposta;
    
    @ManyToOne
    private Avaliacao avaliacao;

    public Questoes(QuestoesDTO questoesDTO) {
        this.id = questoesDTO.getId();
        this.numero = questoesDTO.getNumero();
    }

    public static List<Questoes> converter(List<QuestoesDTO> questoes) {
        if (questoes == null) return null;
        return questoes.stream().map(Questoes::new).collect(Collectors.toList());
    }
}
