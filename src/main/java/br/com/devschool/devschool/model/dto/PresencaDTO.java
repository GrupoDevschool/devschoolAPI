package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Presenca;
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
public class PresencaDTO {

    private Integer id;

    private AlunoDTO aluno;

    private AulaDTO aula;

    private String horaEntrada;

    public PresencaDTO(Presenca presenca) {
        this.id = presenca.getId();
        this.aluno = new AlunoDTO(presenca.getAluno());
        this.aula = new AulaDTO(presenca.getAula());
        this.horaEntrada = presenca.getHoraEntrada();
    }

    public static List<PresencaDTO>converter(List<Presenca> presencas) {
        return presencas.stream().map(PresencaDTO::new).collect(Collectors.toList());
    }

//    public static List<Chamada> convertList(List<ChamadaDTO> chamadas){
//        return chamadas.stream().map(Chamada::new).collect(Collectors.toList());
//
//    }
}
