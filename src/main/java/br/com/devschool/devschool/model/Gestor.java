package br.com.devschool.devschool.model;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import br.com.devschool.devschool.model.dto.GestorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;

    private Tipo tipo;
    
    @ManyToMany(mappedBy = "gestores")
    private List<Aula> aulas;
    
    public Gestor(GestorDTO gestorDTO) {
    	this.id = gestorDTO.getId();
        this.nome = gestorDTO.getNome();
       this.tipo = Gestor.builder().tipo;
    }

	public static List<Gestor> converter(List<GestorDTO> gestores) {
		if (gestores == null) return null;
		return gestores.stream().map(Gestor::new).collect(Collectors.toList());
	}
}
