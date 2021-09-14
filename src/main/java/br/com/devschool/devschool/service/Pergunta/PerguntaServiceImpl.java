package br.com.devschool.devschool.service.Pergunta;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.devschool.devschool.model.Disciplina;
import br.com.devschool.devschool.model.Pergunta;
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
	public List<Pergunta> listarPerguntas(Integer disciplinaId) {
		return perguntaRepository.findAllByDisciplinaId(disciplinaId);
	}

	@Override
	public Pergunta inserirPergunta(PerguntaFormDTO perguntaDTO) {
		Disciplina disciplina = null;
		if (perguntaDTO.getDisciplinaId() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(perguntaDTO.getDisciplinaId());
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("Disciplina inexistente");
			}
			disciplina = disciplinaOptional.get();
		}
		
		Pergunta pergunta = Pergunta.builder()
				.descricao(perguntaDTO.getDescricao())
				.disciplina(disciplina)
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
		if (perguntaDTO.getDisciplinaId() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(perguntaDTO.getDisciplinaId());	
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("disciplina inexitente.");
			}
			disciplina = disciplinaOptional.get();
		}
		
		pergunta.setDescricao(perguntaDTO.getDescricao());
		pergunta.setDisciplina(disciplina);
		
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
