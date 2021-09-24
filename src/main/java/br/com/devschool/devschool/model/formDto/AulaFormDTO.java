package br.com.devschool.devschool.model.formDto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.devschool.devschool.model.dto.GestorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AulaFormDTO {

    @NotBlank
    private String assunto;
    
    @NotBlank
    private String dataHora;

    @NotEmpty
    private List<GestorDTO> gestores;
    
    @NotNull
    private Integer turmaId;
}
