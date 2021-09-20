package br.com.devschool.devschool.service.Pergunta;

import java.util.List;

import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.formDto.PerguntaFormDTO;

public interface PerguntaService {
	List<Pergunta> listarPerguntas(Integer disciplinaId, Integer areaId);

	Pergunta listarPerguntaById(Integer id);
	
	Pergunta inserirPergunta(PerguntaFormDTO perguntaDTO);
	
	Pergunta alterarPergunta(Integer id, PerguntaFormDTO perguntaDTO);
	
	void excluirPergunta(Integer id);
}
