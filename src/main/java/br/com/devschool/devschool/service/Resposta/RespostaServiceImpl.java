package br.com.devschool.devschool.service.Resposta;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.infrastructure.exception.ContentNotFoundException;
import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.RespostaFormDTO;
import br.com.devschool.devschool.repository.DisciplinaRepository;
import br.com.devschool.devschool.repository.RespostaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RespostaServiceImpl implements RespostaService {

	private final RespostaRepository respostaRepository;
	private final DisciplinaRepository disciplinaRepository;

	@Override
	public List<Resposta> listarRespostas(Integer areaId, Integer disciplinaId) {
		if(disciplinaId != null){
			return respostaRepository.findAllByDisciplinaId(disciplinaId);
		}else if(areaId != null){
			return respostaRepository.findByDisciplinaAreaId(areaId);
		}else{
			return respostaRepository.findAll();
		}

	}

	@Override
	public Resposta listarRespostaById(Integer id) {
		return respostaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Resposta com id: " + id + "não encontrada"));
	}

	@Override
	public Resposta inserirResposta(RespostaFormDTO respostaDTO) {
		Disciplina disciplina = disciplinaRepository.findById(respostaDTO.getDisciplinaId())
				.orElseThrow(() -> new ContentNotFoundException("Disciplina com id "+ respostaDTO.getDisciplinaId() +" não encontrada"));
		
		Resposta resposta = Resposta.builder()
				.conteudo(respostaDTO.getConteudo())
				.disciplina(disciplina)
				.build();
		return respostaRepository.save(resposta);
	}

	@Override
	public Resposta alterarResposta(Integer id, RespostaFormDTO respostaDTO) {
		Resposta resposta = respostaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Resposta com id "+ id +" não encontrada"));

		Disciplina disciplina = disciplinaRepository.findById(respostaDTO.getDisciplinaId())
				.orElseThrow(() -> new ContentNotFoundException("Disciplina com id "+ respostaDTO.getDisciplinaId() +" não encontrada"));
		
		resposta.setConteudo(respostaDTO.getConteudo());
		resposta.setDisciplina(disciplina);
		
		return respostaRepository.save(resposta);
	}

	@Override
	public void excluirResposta(Integer id) {
		Resposta resposta = respostaRepository.findById(id)
				.orElseThrow(() -> new ContentNotFoundException("Resposta com id " + id + " não encontrada"));
		
		respostaRepository.deleteById(id);
	}
}
