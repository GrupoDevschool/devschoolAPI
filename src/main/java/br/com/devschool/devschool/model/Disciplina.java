package br.com.devschool.devschool.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Builder
@Data
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	@ManyToMany(mappedBy = "disciplinasRegistradas")
	private List<Trilha> trilhas;
	
}
