package br.com.devschool.devschool.model.dto;


import br.com.devschool.devschool.model.Aula;
import br.com.devschool.devschool.model.Gestores;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GestoresDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;

    private String contato;

    public GestoresDTO(Gestores gestores) {
        this.nome = gestores.getNome();
        this.contato = gestores.getContato();

    }

    public static List<GestoresDTO> converter(List<Gestores> gestores) {
        return gestores.stream().map(GestoresDTO::new).collect(Collectors.toList());
    }

    public static List<Gestores>converterList(List<GestoresDTO> gestores) {
        return gestores.stream().map(Gestores::new).collect(Collectors.toList());
    }
}
