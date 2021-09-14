package br.com.devschool.devschool.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.devschool.devschool.model.dto.AulaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String assunto;

    private String dataHora;
    
    @OneToMany(mappedBy = "aula")
    private List<Chamada> chamada;

    @OneToMany(mappedBy = "aula")
    private List<AulaGestor> aulaGestor;
    
    public Aula(AulaDTO aulaDTO) {
        this.id = aulaDTO.getId();
        this.assunto = aulaDTO.getAssunto();
        this.dataHora = aulaDTO.getDataHora();
    }
}