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
	public Resposta listarRespostaById(Integer id) {
		return respostaRepository.findById(id).get();
	}

	@Override
	public Resposta inserirResposta(RespostaFormDTO respostaDTO) {
		Disciplina disciplina = null;
		if (respostaDTO.getDisciplinaId() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(respostaDTO.getDisciplinaId());
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("Disciplina inexistente");
			}
			disciplina = disciplinaOptional.get();
		}
		
		Resposta resposta = Resposta.builder()
				.descricao(respostaDTO.getDescricao())
				.disciplina(disciplina)
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

		Disciplina disciplina = null;
		if (respostaDTO.getDisciplinaId() != null) {
			Optional<Disciplina> disciplinaOptional = disciplinaRepository.findById(respostaDTO.getDisciplinaId());
			if (disciplinaOptional.isEmpty()) {
				throw new RuntimeException("Disciplina inexistente");
			}
			disciplina = disciplinaOptional.get();
		}
		
		resposta.setDescricao(respostaDTO.getDescricao());
		resposta.setDisciplina(disciplina);
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
