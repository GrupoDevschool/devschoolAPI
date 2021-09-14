package br.com.devschool.devschool.service.Resposta;

import java.util.List;

import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.RespostaFormDTO;


public interface RespostaService {
	
	public List<Resposta> listarRespostas(Integer disciplinaId);
	
	public Resposta inserirResposta(RespostaFormDTO respostaDTO);
	
	public Resposta alterarResposta(Integer id, RespostaFormDTO respostaDTO);
	
	public void excluirResposta(Integer id);
}
