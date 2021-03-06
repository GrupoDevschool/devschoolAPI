package br.com.devschool.devschool.model;


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
public class Presenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    private Aluno aluno;

    @ManyToOne()
    private Aula aula;

    private String horaEntrada;

//    public Chamada(ChamadaDTO chamadaDTO) {
//        this.id = chamadaDTO.getId();
//        this.aluno = chamadaDTO.getAlunoId();
//        this.aula = chamadaDTO.getAulaId();
//        this.horaEntrada = chamadaDTO.getHoraEntrada();
//    }
}