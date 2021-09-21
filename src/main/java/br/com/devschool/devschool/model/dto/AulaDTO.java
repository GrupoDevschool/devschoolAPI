package br.com.devschool.devschool.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AulaDTO {
    private Integer id;

    private String assunto;

    private String dataHora;

    private List<AlunoDTO> alunosPresentes = new ArrayList<>();
    
    private List<GestorDTO> gestoresPresentes = new ArrayList<>();

    private List<Turma> turma;

    public AulaDTO(Aula aula) {
        this.id = aula.getId();
        this.assunto = aula.getAssunto();
        this.dataHora = aula.getDataHora();
        if (aula.getPresenca() != null) {
        	this.alunosPresentes = AlunoDTO.converter(aula.getPresenca().stream().map(c -> c.getAluno()).collect(Collectors.toList()));
        }
        if (aula.getGestores() != null) {
        	this.gestoresPresentes = GestorDTO.converter(aula.getGestores());
        }

    }

    public static List<AulaDTO> converter(List<Aula> aulas) {
        return aulas.stream().map(AulaDTO::new).collect(Collectors.toList());
    }

    public static List<Aula>converterList(List<AulaDTO> areas) {
        return areas.stream().map(Aula::new).collect(Collectors.toList());
    }
}
