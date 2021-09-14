package br.com.devschool.devschool.model.dto;

import br.com.devschool.devschool.model.Aula;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public AulaDTO(Aula aula) {
        this.id = aula.getId();
        this.assunto = aula.getAssunto();
        this.dataHora = aula.getDataHora();
        if (aula.getChamada() != null) {
        	this.alunosPresentes = AlunoDTO.converter(aula.getChamada().stream().map(c -> c.getAluno()).collect(Collectors.toList()));        	
        }
        if (aula.getAulaGestor() != null) {
        	this.gestoresPresentes = GestorDTO.converter(aula.getAulaGestor().stream().map(g -> g.getGestor()).collect(Collectors.toList()));
        }
    }

    public static List<AulaDTO> converter(List<Aula> aulas) {
        return aulas.stream().map(AulaDTO::new).collect(Collectors.toList());
    }

    public static List<Aula>converterList(List<AulaDTO> areas) {
        return areas.stream().map(Aula::new).collect(Collectors.toList());
    }
}
