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
public class ChamadaDTO {

    private Integer id;

    private AlunoDTO aluno;

    private AulaDTO aula;

    private String horaEntrada;

    public ChamadaDTO(Chamada chamada) {
        this.id = chamada.getId();
        this.aluno = new AlunoDTO(chamada.getAluno());
        this.aula = new AulaDTO(chamada.getAula());
        this.horaEntrada = chamada.getHoraEntrada();
    }

    public static List<ChamadaDTO>converter(List<Chamada> chamadas) {
        return chamadas.stream().map(ChamadaDTO::new).collect(Collectors.toList());
    }

//    public static List<Chamada> convertList(List<ChamadaDTO> chamadas){
//        return chamadas.stream().map(Chamada::new).collect(Collectors.toList());
//
//    }
}
