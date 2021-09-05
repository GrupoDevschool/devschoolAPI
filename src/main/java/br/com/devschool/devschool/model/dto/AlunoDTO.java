package br.com.devschool.devschool.model.dto;
import br.com.devschool.devschool.model.Aluno;
import br.com.devschool.devschool.model.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private Integer matricula;

    private String nome;

    private Integer telefone;

    private String email;

    private String observacao;

    public AlunoDTO(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.observacao  = aluno.getObservacao();
    }

    public static List<AlunoDTO> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

}
