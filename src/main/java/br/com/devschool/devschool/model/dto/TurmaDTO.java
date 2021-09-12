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
    private Integer numero;

    private Aluno alunoId;

    private Gestores gestoresId;


    public TurmaDTO(Turma turma) {
        this.numero = turma.getId();
        this.alunoId = turma.getAlunos();
        this.gestoresId = turma.getGestores();

    }

    public static List<TurmaDTO> converter(List<Turma> turmas) {
        return turmas.stream().map(TurmaDTO::new).collect(Collectors.toList());
    }

    public static List<Turma> convertList(List<TurmaDTO> turmas){
        return turmas.stream().map(Turma::new).collect(Collectors.toList());

    }
}
