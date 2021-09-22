package br.com.devschool.devschool.model.formDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PresencaFormDTO {

    @NotNull
	private Integer id;

    @NotNull
    private Integer alunoId;

    @NotNull
    private Integer aulaId;

    @NotBlank
    private String horaEntrada;
}
