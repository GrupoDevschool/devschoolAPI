package br.com.devschool.devschool.model;

import javax.persistence.*;

import br.com.devschool.devschool.model.dto.DisciplinaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	@ManyToMany(mappedBy = "disciplinasRegistradas")
	private List<Trilha> trilhas;
	
	@ManyToOne
	private Area area;

	@OneToMany(mappedBy = "disciplina")
	private List<Pergunta> perguntas;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Resposta> respostas;
	
	public Disciplina(DisciplinaDTO disciplinaDTO) {
		this.id = disciplinaDTO.getId();
		this.nome = disciplinaDTO.getNome();
	}
}
