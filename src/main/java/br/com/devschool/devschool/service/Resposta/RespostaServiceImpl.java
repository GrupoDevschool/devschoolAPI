package br.com.devschool.devschool.service.Resposta;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public List<Resposta> listarRespostas(Integer disciplinaId) {
		return respostaRepository.findAllByDisciplinaId(disciplinaId);
	}

	@Override
	public Resposta inserirResposta(RespostaFormDTO respostaDTO) {
		Optional<Disciplina> disciplinaOptional = Optional.of(null);
		if (respostaDTO.getDisciplinaId() != null) {
			disciplinaOptional = disciplinaRepository.findById(respostaDTO.getDisciplinaId());			
		}
		
		Resposta resposta = Resposta.builder()
				.descricao(respostaDTO.getDescricao())
				.disciplina(disciplinaOptional.get())
				.build();
		return respostaRepository.save(resposta);
	}

	@Override
	public Resposta alterarResposta(Integer id, RespostaFormDTO respostaDTO) {
		Optional<Resposta> respostaOptional = respostaRepository.findById(id);
		if (respostaOptional.isEmpty()) {
			throw new RuntimeException("Resposta não encontrada");
		}
		Resposta resposta = respostaOptional.get();

		Optional<Disciplina> disciplinaOptional = Optional.empty();
		if (respostaDTO.getDisciplinaId() != null) {
			disciplinaOptional = disciplinaRepository.findById(respostaDTO.getDisciplinaId());			
		}
		
		resposta.setDescricao(respostaDTO.getDescricao());
		resposta.setDisciplina(disciplinaOptional.get());
		return respostaRepository.save(resposta);
	}

	@Override
	public void excluirResposta(Integer id) {
		Optional<Resposta> respostaOptional = respostaRepository.findById(id);
		if (respostaOptional.isEmpty()) {
			throw new RuntimeException("Resposta não encontrada");
		}

		respostaRepository.deleteById(id);
	}
}
