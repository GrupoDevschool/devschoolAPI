package br.com.devschool.devschool.model;


import java.util.List;

import javax.persistence.*;

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
    private List<Presenca> presenca;

    @ManyToOne
    private Turma turma;

    @ManyToMany
    @JoinTable(name="aula_gestor",
            joinColumns={@JoinColumn(name="aula_id")},
            inverseJoinColumns={@JoinColumn(name="gestor_id")})
    private List<Gestor> gestores;
    
    public Aula(AulaDTO aulaDTO) {
        this.id = aulaDTO.getId();
        this.assunto = aulaDTO.getAssunto();
        this.dataHora = aulaDTO.getDataHora();
    }
}
