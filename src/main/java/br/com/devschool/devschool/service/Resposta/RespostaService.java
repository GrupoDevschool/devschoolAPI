package br.com.devschool.devschool.service.Resposta;

import java.util.List;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.RespostaFormDTO;


public interface RespostaService {
	
	List<Resposta> listarRespostas( Integer disciplinaId);

	Resposta listarRespostaById(Integer id);


	Resposta inserirResposta(RespostaFormDTO respostaDTO);
	
	Resposta alterarResposta(Integer id, RespostaFormDTO respostaDTO);
	
	void excluirResposta(Integer id);
}
