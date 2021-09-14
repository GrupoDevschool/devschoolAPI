package br.com.devschool.devschool.service.Pergunta;

import java.util.List;

import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.formDto.PerguntaFormDTO;

public interface PerguntaService {
	public List<Pergunta> listarPerguntas(Integer disciplinaId);
	
	public Pergunta inserirPergunta(PerguntaFormDTO perguntaDTO);
	
	public Pergunta alterarPergunta(Integer id, PerguntaFormDTO perguntaDTO);
	
	public void excluirPergunta(Integer id);
}
