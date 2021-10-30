package br.com.devschool.devschool.model;

import br.com.devschool.devschool.model.dto.GrupoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Tarefa> tarefas = new ArrayList<>();
    
    public Grupo(GrupoDTO grupoDTO) {
        this.id = grupoDTO.getId();
        this.nome = grupoDTO.getNome();
    }
}
