package br.com.devschool.devschool.model.dto;


import br.com.devschool.devschool.model.*;
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
public class TurmaDTO {
	
    private Integer id;

    private String nome;

    public TurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
    }

    public static List<TurmaDTO> converter(List<Turma> turmas) {
    	if (turmas == null) return null;
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }

    public static List<Turma> convertList(List<TurmaDTO> turmas){
    	if (turmas == null) return null;
        return turmas.stream().map(Turma::new).collect(Collectors.toList());

    }
}
