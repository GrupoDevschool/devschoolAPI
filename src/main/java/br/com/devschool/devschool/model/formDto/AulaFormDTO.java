package br.com.devschool.devschool.model.formDto;

import java.util.List;

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
	private Integer id;
    private String assunto;
    private String dataHora;
    private List<GestorDTO> gestores;
}
