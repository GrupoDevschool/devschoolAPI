package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Trilha;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrilhaDTO {

    private Long id;

    private String nome;

    private List<DisciplinaDTO> disciplinas;

    public TrilhaDTO(Trilha trilha) {
        this.id = trilha.getId();
        this.nome = trilha.getNome();
        this.disciplinas = DisciplinaDTO.converter(trilha.getDisciplinasRegistradas());
    }

    public static List<TrilhaDTO> convertList(List<Trilha> escritorios) {
        return escritorios.stream().map(TrilhaDTO::new).collect(Collectors.toList());
    }

}
