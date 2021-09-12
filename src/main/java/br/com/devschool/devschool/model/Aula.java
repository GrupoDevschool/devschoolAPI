package br.com.devschool.devschool.model;


import br.com.devschool.devschool.model.dto.AulaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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


    public Aula(AulaDTO aulaDTO) {
        this.id = aulaDTO.getId();
        this.assunto = aulaDTO.getAssunto();
        this.dataHora = aulaDTO.getDataHora();
    }
}
