package br.com.devschool.devschool.service.Pergunta;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Pergunta;
import br.com.devschool.devschool.model.Resposta;
import br.com.devschool.devschool.model.formDto.PerguntaFormDTO;
import br.com.devschool.devschool.repository.DisciplinaRepository;
import br.com.devschool.devschool.repository.PerguntaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PerguntaServiceImpl  implements PerguntaService{
	
	private final PerguntaRepository perguntaRepository;
	private final DisciplinaRepository disciplinaRepository;
	
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
		return perguntaRepository.findById(id).get();
	}

	@Override
	public Pergunta inserirPergunta(PerguntaFormDTO perguntaDTO) {
		Disciplina disciplina = null;
		if (perguntaDTO.getDisciplina() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(perguntaDTO.getDisciplina());
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("Disciplina inexistente");
			}
			disciplina = disciplinaOptional.get();
		}
		
		List<Resposta> respostas = Resposta.converter(perguntaDTO.getRespostas());
		
		Pergunta pergunta = Pergunta.builder()
				.enunciado(perguntaDTO.getEnunciado())
				.disciplina(disciplina)
				.respostas(respostas)
				.build();
		return perguntaRepository.save(pergunta);
	}

	@Override
	public Pergunta alterarPergunta(Integer id, PerguntaFormDTO perguntaDTO) {
		Optional<Pergunta> perguntaOptional = perguntaRepository.findById(id);
		if (perguntaOptional.isEmpty()) {
			throw new RuntimeException("Pergunta não encontrada");
		}
		Pergunta pergunta = perguntaOptional.get();
		
		Disciplina disciplina = null;
		if (perguntaDTO.getDisciplina() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(perguntaDTO.getDisciplina());	
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("disciplina inexitente.");
			}
			disciplina = disciplinaOptional.get();
		}
		
		List<Resposta> respostas = Resposta.converter(perguntaDTO.getRespostas());
		
		pergunta.setEnunciado(perguntaDTO.getEnunciado());
		pergunta.setDisciplina(disciplina);
		pergunta.setRespostas(respostas);
		
		return perguntaRepository.save(pergunta);
	}

	@Override
	public void excluirPergunta(Integer id) {
		Optional<Pergunta> perguntaOptional = perguntaRepository.findById(id);
		if (perguntaOptional.isEmpty()) {
			throw new RuntimeException("Pergunta não encontrada");
		}
		
		perguntaRepository.deleteById(id);
	}
}
