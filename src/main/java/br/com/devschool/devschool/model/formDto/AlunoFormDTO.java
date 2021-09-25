package br.com.devschool.devschool.model.formDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoFormDTO {

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
