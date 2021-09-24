package br.com.devschool.devschool.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.devschool.model.Aula;
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
    
    private List<GestorDTO> gestoresPresentes = new ArrayList<>();

    private TurmaDTO turma;

    public AulaDTO(Aula aula) {
        this.id = aula.getId();
        this.assunto = aula.getAssunto();
        this.dataHora = aula.getDataHora();
        this.turma = new TurmaDTO(aula.getTurma());
        if (aula.getGestores() != null) {
        	this.gestoresPresentes = GestorDTO.converter(aula.getGestores());
        }

    }

    public static List<AulaDTO> converter(List<Aula> aulas) {
    	if (aulas == null) return null;
        return aulas.stream().map(AulaDTO::new).collect(Collectors.toList());
    }

    public static List<Aula>converterList(List<AulaDTO> areas) {
    	if (areas == null) return null;
    	return areas.stream().map(Aula::new).collect(Collectors.toList());
    }
}
