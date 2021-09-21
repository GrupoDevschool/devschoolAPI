package br.com.devschool.devschool.model;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.devschool.devschool.model.dto.RespostaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String conteudo;
	
	@ManyToOne
	private Disciplina disciplina;

	@ManyToOne
	private Area area;
	
	@ManyToMany(mappedBy = "respostas")
	private List<Pergunta> perguntas;

	@ManyToMany
	private List<Questoes> questoes;
	
	public Resposta(RespostaDTO respostaDTO) {
		this.id = respostaDTO.getId();
		this.conteudo = respostaDTO.getConteudo();
		this.disciplina = new Disciplina(respostaDTO.getDisciplina());
		this.area = new Area(respostaDTO.getArea());
	}
	
	public static List<Resposta> converter(List<RespostaDTO> respostas) {
		if (respostas == null) return null;
		return respostas.stream().map(Resposta::new).collect(Collectors.toList());
		
	}
}
