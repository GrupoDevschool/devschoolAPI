package br.com.devschool.devschool.model.formDto;

import br.com.devschool.devschool.model.dto.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoFormDTO {

    @NotNull
	private Integer matricula;

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotBlank
    private String email;

    @NotBlank
    private String observacao;


    @NotNull
    private Integer turmaId;
    
    
}
