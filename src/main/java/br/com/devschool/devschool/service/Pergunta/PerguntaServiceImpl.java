package br.com.devschool.devschool.service.Pergunta;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.infrastructure.exception.PerguntaMalFormuladaException;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.PerguntaFormDTO;
import br.com.devschool.devschool.repository.PerguntaRepository;
import br.com.devschool.devschool.repository.RespostaRepository;
import br.com.devschool.devschool.service.Disciplina.DisciplinaService;
import br.com.devschool.devschool.service.Resposta.RespostaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PerguntaServiceImpl  implements PerguntaService{
	
	private final PerguntaRepository perguntaRepository;
	private final DisciplinaService disciplinaService;
	private final RespostaRepository respostaRepository;
	private final RespostaService respostaService;
	
	@Override
	public List<Pergunta> listarPerguntas(Integer disciplinaId, Integer areaId) {
		if(disciplinaId != null){
			return perguntaRepository.findAllByDisciplinaId(disciplinaId);
		}else if(areaId != null){
			return perguntaRepository.findByDisciplinaAreaId(areaId);
		}else {
			return perguntaRepository.findAll();
		}
	}

	@Override
	public Pergunta listarPerguntaById(Integer id) {
		return perguntaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Pergunta com id "+ id + " não encontrada"));
	}

	@Override
	public Pergunta inserirPergunta(PerguntaFormDTO perguntaDTO) {
		Disciplina disciplina = disciplinaService.getDisciplinaById(perguntaDTO.getDisciplina());

		Resposta respostaCorreta = respostaService.listarRespostaById(perguntaDTO.getRespostaCorreta());

		List<Resposta> respostas = respostaRepository.findAllById(perguntaDTO.getRespostas());
		
		if (!respostas.contains(respostaCorreta)) {
			throw new PerguntaMalFormuladaException(
					String.format("A resposta correta não consta nas opcoes de respostas possiveis. id resposta corresta: %d, id respostas possiveis %s"
							, perguntaDTO.getRespostaCorreta()
							, perguntaDTO.getRespostas()
						));
		}
		
		
		Pergunta pergunta = Pergunta.builder()
				.enunciado(perguntaDTO.getEnunciado())
				.disciplina(disciplina)
				.responstaCorreta(respostaCorreta)
				.respostas(respostas)
				.build();
		return perguntaRepository.save(pergunta);
	}

	@Override
	public Pergunta alterarPergunta(Integer id, PerguntaFormDTO perguntaDTO) {
		Pergunta pergunta = this.listarPerguntaById(id);
		Disciplina disciplina = disciplinaService.getDisciplinaById(perguntaDTO.getDisciplina());
		Resposta respostaCorreta = respostaService.listarRespostaById(perguntaDTO.getRespostaCorreta());
		
		List<Resposta> respostas = respostaRepository.findAllById(perguntaDTO.getRespostas());
		if (!respostas.contains(respostaCorreta)) {
			throw new PerguntaMalFormuladaException(
					String.format("A resposta correta não consta nas opcoes de respostas possiveis. id resposta corresta: %d, id respostas possiveis %s"
							, perguntaDTO.getRespostaCorreta()
							, perguntaDTO.getRespostas()
						));
		}
		
		pergunta.setEnunciado(perguntaDTO.getEnunciado());
		pergunta.setResponstaCorreta(respostaCorreta);
		pergunta.setDisciplina(disciplina);
		pergunta.setRespostas(respostas);
		
		return perguntaRepository.save(pergunta);
	}

	@Override
	public void excluirPergunta(Integer id) {
		this.listarPerguntaById(id);
		
		perguntaRepository.deleteById(id);
	}
}
