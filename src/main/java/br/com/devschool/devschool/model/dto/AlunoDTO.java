package br.com.devschool.devschool.model.dto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private Integer matricula;

    private String nome;

    private String telefone;

    private String email;

    private String observacao;
    
    private String turma;

    public AlunoDTO(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.telefone = aluno.getTelefone();
        this.email = aluno.getEmail();
        this.observacao  = aluno.getObservacao();
        if (aluno.getTurma() != null) {
        	this.turma = aluno.getTurma().getNome();        	
        }
    }


    public static List<AlunoDTO> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

}
