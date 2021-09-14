package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChamadaFormDTO {

	private Integer id;

    private Integer alunoId;

    private Integer aulaId;

    private String horaEntrada;
}
