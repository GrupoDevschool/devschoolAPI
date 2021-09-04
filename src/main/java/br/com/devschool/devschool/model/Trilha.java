package br.com.devschool.devschool.model;

import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import br.com.devschool.devschool.model.dto.TrilhaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name="trilha_disciplina",
            joinColumns={@JoinColumn(name="trilha_id")},
            inverseJoinColumns={@JoinColumn(name="disciplina_id")})
    private List<Disciplina> disciplinasRegistradas;
}
