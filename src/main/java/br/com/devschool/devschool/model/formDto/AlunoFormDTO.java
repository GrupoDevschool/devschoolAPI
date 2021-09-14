package br.com.devschool.devschool.model.formDto;

import br.com.devschool.devschool.model.dto.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoFormDTO {
	
	private Integer matricula;
    private String nome;
    private String telefone;
    private String email;
    private String observacao;
    private Integer turmaId;
    
    
}
