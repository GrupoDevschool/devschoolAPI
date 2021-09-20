package br.com.devschool.devschool.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String enunciado;
	
	@ManyToOne
	private Disciplina disciplina;

	@ManyToOne
	private Resposta responstaCorreta;
	
	@ManyToMany
	@JoinTable(name="pergunta_resposta",
    joinColumns={@JoinColumn(name="pergunta_id")},
    inverseJoinColumns={@JoinColumn(name="resposta_id")})
	private List<Resposta> respostas;
}
