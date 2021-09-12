package br.com.devschool.devschool.model;

import br.com.devschool.devschool.model.dto.TurmaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    @ManyToOne()
    private Aluno alunos;

    @ManyToOne()
    private Gestores gestores;

    public Turma(TurmaDTO turmaDTO) {
        this.numero = turmaDTO.getNumero();
        this.alunos = turmaDTO.getAlunoId();
        this.gestores = turmaDTO.getGestoresId();
    }
}
